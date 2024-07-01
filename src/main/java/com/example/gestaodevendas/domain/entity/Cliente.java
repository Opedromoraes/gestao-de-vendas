package com.example.gestaodevendas.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @NotBlank(message = "O nome é obrigatório")
    @JoinColumn(name = "nome",nullable = false)
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @JoinColumn(name = "email",nullable = false)
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    @JoinColumn(name = "telefone",nullable = false)
    private String telefone;

    @NotBlank(message = "O cpf é obrigatório")
    @JoinColumn(name = "cpf",nullable = false)
    private String cpf;


}
