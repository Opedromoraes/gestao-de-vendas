package com.example.gestaodevendas.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;


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
    @Column(name = "nome",nullable = false)
    private String nome;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "O email não existe")
    @Column(name = "email",nullable = false, unique = true)
    private String email;

    @NotBlank(message = "O telefone é obrigatório")
    @Column(name = "telefone",nullable = false, unique = true)
    private String telefone;

    @NotBlank(message = "O cpf é obrigatório")
    @CPF(message = "O cpf não é válido")
    @Column(name = "cpf",nullable = false, unique = true)
    private String cpf;


}
