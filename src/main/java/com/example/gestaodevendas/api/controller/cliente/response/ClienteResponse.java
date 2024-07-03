package com.example.gestaodevendas.api.controller.cliente.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    Long idCliente;
    String nome;
    String email;
    String telefone;
    String cpf;

}
