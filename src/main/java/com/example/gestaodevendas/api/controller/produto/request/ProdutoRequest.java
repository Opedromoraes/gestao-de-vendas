package com.example.gestaodevendas.api.controller.produto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class ProdutoRequest {

    @Schema(description = "Nome do produto",example = "Nike AirForce")
    private String nome;

    @Schema(description = "Preço do produto",example = "600")
    private Double preco;

    @Schema(description = "Descrição do produto",example = "Tênis Nike Air Force 1' 07 Masculino, Número 40, Construído em couro, solado de borracha e gola acolchoada")
    private String decricao;

    @Schema(description = "Quantidade",example = "3")
    private Integer quantidade;

    @Schema(description = "Id da categoria",example = "1")
    private Long idCategoria;

}
