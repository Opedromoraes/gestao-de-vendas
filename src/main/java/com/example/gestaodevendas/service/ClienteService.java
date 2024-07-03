package com.example.gestaodevendas.service;

import com.example.gestaodevendas.domain.dto.ClienteDTO;
import com.example.gestaodevendas.domain.entity.Cliente;
import com.example.gestaodevendas.domain.mapper.ClienteMapper;
import com.example.gestaodevendas.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;


    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        verificarCliente(clienteDTO);
        Cliente cliente = mapper.dtoToEntity(clienteDTO);
        return mapper.entityToDTO(repository.save(cliente));

    }


    public ClienteDTO verificarCliente(ClienteDTO clienteDTO) {
        if (!repository.findByEmail(clienteDTO.getEmail()).isEmpty()) {
            throw new RuntimeException("Email já cadastrado");
        }
        if (!repository.findByTelefone(clienteDTO.getTelefone()).isEmpty()) {
            throw new RuntimeException("Telefone já cadastrado");
        }
        if (!repository.findByCpf(clienteDTO.getCpf()).isEmpty()) {
            throw new RuntimeException("CPF já cadastrado");
        }
//        Cliente cliente = mapper.dtoToEntity(clienteDTO);
//        repository.save(cliente);
//        ClienteDTO clienteDTO1 = mapper.entityToDTO(cliente);

        return clienteDTO;
    }

    public void deletarCliente(Long id) {
        repository.deleteById(id);
    }

    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = repository.findById(id).get();
        return mapper.entityToDTO(cliente);
    }

}
