package com.example.gestaodevendas.repository;

import com.example.gestaodevendas.domain.entity.Cliente;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByEmail(String email);
    List<Cliente> findByCpf(String cpf);
    List<Cliente> findByTelefone(String telefone);

}
