package com.example.gestaodevendas.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    Long idCliente;
    String nome;
    String email;
    String telefone;
    String cpf;

}
