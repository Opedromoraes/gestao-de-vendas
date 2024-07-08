package com.example.gestaodevendas.repository;

import com.example.gestaodevendas.domain.entity.Categoria;
import com.example.gestaodevendas.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

//    Cliente findByEmail(String email);
//    Cliente findByCpf(String cpf);
//    Cliente findByTelefone(String telefone);

}