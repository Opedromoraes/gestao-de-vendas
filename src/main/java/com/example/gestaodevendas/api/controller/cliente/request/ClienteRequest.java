package com.example.gestaodevendas.api.controller.cliente.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClienteRequest {

    private String nome;
    private String email;
    private String telefone;
    private String cpf;

}
