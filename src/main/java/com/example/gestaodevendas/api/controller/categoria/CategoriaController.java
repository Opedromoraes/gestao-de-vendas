package com.example.gestaodevendas.api.controller.categoria;

import com.example.gestaodevendas.api.controller.categoria.request.CategoriaRequest;
import com.example.gestaodevendas.api.controller.categoria.response.CategoriaResponse;
import com.example.gestaodevendas.api.controller.cliente.IClienteController;
import com.example.gestaodevendas.api.controller.cliente.request.ClienteRequest;
import com.example.gestaodevendas.api.controller.cliente.response.ClienteResponse;
import com.example.gestaodevendas.domain.dto.CategoriaDTO;
import com.example.gestaodevendas.domain.dto.ClienteDTO;
import com.example.gestaodevendas.domain.mapper.CategoriaMapper;
import com.example.gestaodevendas.domain.mapper.ClienteMapper;
import com.example.gestaodevendas.service.CategoriaService;
import com.example.gestaodevendas.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class CategoriaController implements ICategoriaController {

    private final CategoriaService service;
    private final CategoriaMapper mapper;

    @Override
    public ResponseEntity<CategoriaResponse> create(CategoriaRequest request) {
        CategoriaDTO categoriaDTO = service.salvar(mapper.requestToDto(request));
        CategoriaResponse response = mapper.dtoToResponse(categoriaDTO);
        return ResponseEntity.status(CREATED).body(response);
    }

    @Override
    public ResponseEntity<CategoriaResponse> buscarPorId(Long id) {
        CategoriaDTO categoriaDTO = service.buscarPorId(id);
        CategoriaResponse response = mapper.dtoToResponse(categoriaDTO);
        return ResponseEntity.status(OK).body(response);
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
                service.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
