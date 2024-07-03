package com.example.gestaodevendas.api.controller.cliente.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true, access = AccessLevel.PRIVATE)
public class ClienteRequest {

    @Schema(description = "Nome do cliente",example = "Pedro")
    private String nome;

    @Schema(description = "Email do cliente",example = "pedro@gmail.com")
    private String email;

    @Schema(description = "Telefone do cliente",example = "31991317054")
    private String telefone;

    @Schema(description = "Cpf do cliente",example = "01899247645")
    private String cpf;

}
