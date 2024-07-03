package com.example.gestaodevendas.api.controller.cliente;

import com.example.gestaodevendas.api.controller.cliente.request.ClienteRequest;
import com.example.gestaodevendas.api.controller.cliente.response.ClienteResponse;
import com.example.gestaodevendas.domain.dto.ClienteDTO;
import com.example.gestaodevendas.domain.entity.Cliente;
//import com.example.gestaodevendas.domain.mapper.ClienteMapper;
import com.example.gestaodevendas.domain.mapper.ClienteMapper;
import com.example.gestaodevendas.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.http.HttpStatus.*;

@RestController
@RequiredArgsConstructor
public class ClienteController implements IClienteController {

    private final ClienteService service;
    private final ClienteMapper mapper;


    @Override
    public ResponseEntity<ClienteResponse> create(ClienteRequest request) {
        ClienteDTO clienteDTO = service.salvar(mapper.requestToDto(request));
        ClienteResponse response = mapper.dtoToResponse(clienteDTO);
        return ResponseEntity.status(CREATED).body(response);

    }

    @Override
    public ResponseEntity<ClienteResponse> buscarPorId(Long id) {
        ClienteDTO clienteDTO = service.buscarPorId(id);
        ClienteResponse response = mapper.dtoToResponse(clienteDTO);
        return ResponseEntity.status(OK).body(response);
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

//    @Override
//    public ResponseEntity<ClienteResponse> atualizar(Long id, Cliente clienteNovo) {
//        ClienteDTO clienteDTO = service.buscarPorId(id);
//        Cliente cliente = mapper.dtoToEntity(clienteDTO);
//
//        if (cliente.getIdCliente() != null) {
//
//            Cliente clienteAtualizado = cliente;
//            clienteAtualizado.setCpf(clienteNovo.getCpf());
//            clienteAtualizado.setNome(clienteNovo.getNome());
//            clienteAtualizado.setEmail(clienteNovo.getEmail());
//            clienteAtualizado.setTelefone(clienteNovo.getTelefone());
//            ClienteDTO clienteDTO = mapper.entityToDTO(clienteAtualizado);
//            service.salvar(clienteDTO);
//            ClienteResponse response = mapper.dtoToResponse(clienteDTO);
//            return ResponseEntity.status(OK).body(response);
//        }
//            return ResponseEntity.status(NOT_FOUND).build();
//
//    }

}
