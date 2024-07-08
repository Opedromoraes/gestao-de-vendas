package com.example.gestaodevendas.api.controller.categoria.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class CategoriaRequest {

    @Schema(description = "Nome da categoria",example = "Tênis")
    private String nome;

}
