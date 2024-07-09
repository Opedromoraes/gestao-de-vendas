package com.example.gestaodevendas.api.controller.produto;

import com.example.gestaodevendas.api.controller.produto.request.ProdutoRequest;
import com.example.gestaodevendas.api.controller.produto.response.ProdutoResponse;
import com.example.gestaodevendas.domain.dto.ProdutoDTO;
import com.example.gestaodevendas.domain.mapper.ProdutoMapper;
import com.example.gestaodevendas.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
public class ProdutoController implements IProdutoController {

    private final ProdutoService service;
    private final ProdutoMapper mapper;

    @Override
    public ResponseEntity<ProdutoResponse> criar(ProdutoRequest request) {
        ProdutoDTO produtoDTO = service.salvar(mapper.requestToDto(request));
        ProdutoResponse response = mapper.dtoToResponse(produtoDTO);
        return ResponseEntity.status(CREATED).body(response);
    }

    @Override
    public ResponseEntity<ProdutoResponse> buscarPorId(Long id) {
        ProdutoDTO produtoDTO = service.buscarPorId(id);
        ProdutoResponse response = mapper.dtoToResponse(produtoDTO);
        return ResponseEntity.status(OK).body(response);
    }

    @Override
    public ResponseEntity<ProdutoResponse> atualizar(Long id, ProdutoRequest request) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deletar(Long id) {
        return null;
    }


//
//    @Override
//    public ResponseEntity<Void> deletar(Long id) {
//                service.deletarCliente(id);
//        return ResponseEntity.noContent().build();
//    }

}
