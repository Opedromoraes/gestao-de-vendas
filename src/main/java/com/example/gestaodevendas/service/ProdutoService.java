package com.example.gestaodevendas.service;

import com.example.gestaodevendas.domain.dto.CategoriaDTO;
import com.example.gestaodevendas.domain.dto.ClienteDTO;
import com.example.gestaodevendas.domain.dto.ProdutoDTO;
import com.example.gestaodevendas.domain.entity.Produto;
import com.example.gestaodevendas.domain.exceptions.BusinessException;
import com.example.gestaodevendas.domain.exceptions.DataBaseException;
import com.example.gestaodevendas.domain.exceptions.NotFoundException;
import com.example.gestaodevendas.domain.mapper.ProdutoMapper;
import com.example.gestaodevendas.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoMapper mapper;
    private final CategoriaService categoriaService;

    public ProdutoDTO salvar(ProdutoDTO produtoDTO) {

        associarCategoria(produtoDTO);
        Produto produto = mapper.dtoToEntity(produtoDTO);
        try {
            repository.save(produto);
        } catch (Exception ex){
            throw new DataBaseException("Erro ao acessar o banco de dados");
        }
        return mapper.entityToDTO(produto);
    }

    public ProdutoDTO buscarPorId(Long id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
        return mapper.entityToDTO(produto);
    }

    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        ProdutoDTO produtoAntigoDTO = buscarPorId(id);
        verificarProduto(produtoDTO);

        Produto produto = mapper.dtoToEntity(produtoAntigoDTO);
        produto.setNome(produtoDTO.getNome());
        produto.setDecricao(produtoDTO.getDecricao());
        produto.setPreco(produtoDTO.getPreco());
        produto.setQuantidade(produtoDTO.getQuantidade());

        return mapper.entityToDTO(repository.save(produto));

    }

    public ProdutoDTO verificarProduto(ProdutoDTO produtoDTO) {
        Optional<Produto> produtoOpt = repository.findByNome(produtoDTO.getNome());
        produtoOpt.orElseThrow(() -> new BusinessException("Produto já cadastrado"));

        return mapper.entityToDTO(produtoOpt.get());
    }

    public void deletarProduto(Long id) {
        ProdutoDTO produtoDTO = buscarPorId(id);
        mapper.dtoToEntity(produtoDTO);
        repository.deleteById(id);
    }

    private void associarCategoria(ProdutoDTO produtoDTO) {
        if (produtoDTO.getIdCategoria() != null) {
            CategoriaDTO categoriaDTO = categoriaService.buscarPorId(produtoDTO.getIdCategoria());
            produtoDTO.setCategoria(categoriaDTO);
            produtoDTO.setIdCategoria(categoriaDTO.getIdCategoria());
        }
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

//}
