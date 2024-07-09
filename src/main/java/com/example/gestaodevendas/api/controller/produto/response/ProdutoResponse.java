package com.example.gestaodevendas.api.controller.produto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {

    Long idProduto;
    String nome;
    Double preco;
    String decricao;
    Integer quantidade;
    Long idCategoria;

}
