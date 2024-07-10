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

    private Long idProduto;
    private String nome;
    private Double preco;
    private String decricao;
    private Integer quantidade;
    private Long idCategoria;
    private CategoriaDTO categoria;

}
