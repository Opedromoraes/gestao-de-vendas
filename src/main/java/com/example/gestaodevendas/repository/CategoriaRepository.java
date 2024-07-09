package com.example.gestaodevendas.repository;

import com.example.gestaodevendas.domain.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
