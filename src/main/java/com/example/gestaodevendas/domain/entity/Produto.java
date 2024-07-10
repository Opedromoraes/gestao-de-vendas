package com.example.gestaodevendas.domain.entity;

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
@Table(name = "produto", schema = "public")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProduto;

    @NotBlank
    @Column(nullable = false,unique = true)
    String nome;

    @Column(nullable = false)
    Double preco;

    @NotBlank
    @Column(nullable = false)
    String decricao;

    @Column(nullable = false)
    Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;
}
