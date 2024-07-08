package com.example.gestaodevendas.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoria", schema = "public")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @NotBlank(message = "O nome é obrigatório")
    @JoinColumn(name = "nome",nullable = false)
    private String nome;

//    @ManyToOne
//    @JoinColumn(name = "id_cardapio")
//    private Cardapio cardapio;
    // Colocar isso aqui em produtos (baseando a categoria no lugar de cardapio)

//    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Produto> produto;



}
