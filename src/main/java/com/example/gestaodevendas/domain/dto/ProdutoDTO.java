package com.example.gestaodevendas.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    Long idProduto;
    String nome;
    Double preco;
    String decricao;
    Integer quantidade;
    Long idCategoria;
    CategoriaDTO categoriaDTO;

}
