package com.example.gestaodevendas.api.controller.cliente;

import com.example.gestaodevendas.api.controller.cliente.request.ClienteRequest;
import com.example.gestaodevendas.api.controller.cliente.response.ClienteResponse;
import com.example.gestaodevendas.domain.dto.ClienteDTO;
import com.example.gestaodevendas.domain.mapper.ClienteMapper;
import com.example.gestaodevendas.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

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

//    @Override
//    public ResponseEntity<ClienteResponse> buscarPorId(Long id) {
//        ClienteDTO clienteDTO = service.buscarPorId(id);
//        return null;
//    }

}
