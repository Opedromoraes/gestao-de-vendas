package com.example.gestaodevendas.api.controller.cliente;

import com.example.gestaodevendas.api.controller.cliente.request.ClienteRequest;
import com.example.gestaodevendas.api.controller.cliente.response.ClienteResponse;
import com.example.gestaodevendas.domain.dto.ClienteDTO;
import com.example.gestaodevendas.domain.entity.Cliente;
import com.example.gestaodevendas.domain.mapper.ClienteMapper;
import com.example.gestaodevendas.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class ClienteController implements IClienteController{

    private final ClienteService service;
    private final ClienteMapper mapper;

    public ClienteController(ClienteService service, ClienteMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @Override
    public ResponseEntity<ClienteResponse> create(ClienteRequest request) {
        ClienteDTO clienteDTO = service.salvar(mapper.requestToDto(request));
        ClienteResponse response = mapper.dtoToResponse(clienteDTO);
        return ResponseEntity.status(CREATED).body(response);
    }

    @Override
    public ResponseEntity<ClienteResponse> buscarPorId(Long id) {
        Optional<Cliente> cliente = service.buscarPorId(id);
        ClienteResponse response = mapper.dtoToResponse(cliente);
        return ResponseEntity.status(OK).body(response);
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ClienteResponse> atualizar(Long id, Cliente detalhesCliente) {
        Optional<Cliente> cliente = service.buscarPorId(id);

        if (cliente.isPresent()){
            Cliente clienteAtualizado = cliente.get();
            clienteAtualizado.setIdCliente(detalhesCliente.getIdCliente());
            clienteAtualizado.setCpf(detalhesCliente.getCpf());
            clienteAtualizado.setNome(detalhesCliente.getNome());
            clienteAtualizado.setEmail(detalhesCliente.getEmail());
            ClienteDTO clienteDTO = mapper.entityToDTO(clienteAtualizado);
             service.salvar(clienteDTO);
             ClienteResponse response = mapper.dtoToResponse(clienteDTO);
             return ResponseEntity.status(OK).body(response);
        }
    }


}
