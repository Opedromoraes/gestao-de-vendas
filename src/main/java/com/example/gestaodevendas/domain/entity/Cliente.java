package com.example.gestaodevendas.domain.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente", schema = "public")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @NotBlank(message = "O nome é obrigatório")
    @JoinColumn(name = "nome",nullable = false)
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @JoinColumn(name = "email",nullable = false, unique = true)
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    @JoinColumn(name = "telefone",nullable = false, unique = true)
    private String telefone;

    @NotBlank(message = "O cpf é obrigatório")
    @JoinColumn(name = "cpf",nullable = false, unique = true)
    private String cpf;


}
