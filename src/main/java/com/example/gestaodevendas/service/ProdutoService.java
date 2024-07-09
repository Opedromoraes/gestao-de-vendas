package com.example.gestaodevendas.service;

import com.example.gestaodevendas.domain.dto.CategoriaDTO;
import com.example.gestaodevendas.domain.dto.ProdutoDTO;
import com.example.gestaodevendas.domain.entity.Categoria;
import com.example.gestaodevendas.domain.entity.Produto;
import com.example.gestaodevendas.domain.mapper.CategoriaMapper;
import com.example.gestaodevendas.domain.mapper.ProdutoMapper;
import com.example.gestaodevendas.repository.CategoriaRepository;
import com.example.gestaodevendas.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;
    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    public ProdutoDTO salvar(ProdutoDTO produtoDTO) {

        associarCategoria(produtoDTO);
        Produto produto = mapper.dtoToEntity(produtoDTO);
        produto.setCategoria(categoriaMapper.dtoToEntity(produtoDTO.getCategoriaDTO()));
        repository.save(produto);
        return mapper.entityToDTO(produto);
    }

    private void associarCategoria(ProdutoDTO produtoDTO) {
        if (produtoDTO.getIdCategoria() != null) {
            CategoriaDTO categoriaDTO = categoriaService.buscarPorId(produtoDTO.getIdCategoria());
            produtoDTO.setCategoriaDTO(categoriaDTO);
            produtoDTO.setIdCategoria(categoriaDTO.getIdCategoria());
        }
    }

    public ProdutoDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return mapper.entityToDTO(produto);
    }
}

//    public CategoriaDTO buscarPorId(Long id) {
//        Categoria categoria =repository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
//        return mapper.entityToDTO(categoria);
//    }
//
//    public void deletarCliente(Long id) {
//        repository.deleteById(id);
//    }
//}

//
//    public ClienteDTO verificarCliente(Long id,ClienteDTO clienteDTO) {
//        Cliente clienteEncontrado = repository.findByEmail(clienteDTO.getEmail());
//
//        if (clienteEncontrado != null && !clienteEncontrado.getIdCliente().equals(id)) {
//            throw new RuntimeException("Email já cadastrado");
//        }
//        clienteEncontrado = repository.findByCpf(clienteDTO.getCpf());
//
//        if (clienteEncontrado != null && !clienteEncontrado.getIdCliente().equals(id)) {
//            throw new RuntimeException("CPF já cadastrado");
//        }
//
//        clienteEncontrado = repository.findByTelefone(clienteDTO.getTelefone());
//
//        if (clienteEncontrado != null && !clienteEncontrado.getIdCliente().equals(id)) {
//            throw new RuntimeException("Telefone já cadastrado");
//        }
//
//        return mapper.entityToDTO(clienteEncontrado);
//    }

//}
