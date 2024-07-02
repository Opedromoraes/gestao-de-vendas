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

    public ClienteService(ClienteRepository repository, ClienteMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public ClienteDTO salvar(ClienteDTO clienteDTO) {

        verificarCliente(clienteDTO);
        Cliente cliente = repository.save(mapper.dtoToEntity(clienteDTO));
        return mapper.entityToDTO(cliente);
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public ClienteDTO verificarCliente(ClienteDTO clienteDTO){
        if (clienteDTO.getEmail() != null){
            throw new RuntimeException("Email já cadastrado");
        }
        if (clienteDTO.getCpf() != null){
            throw new RuntimeException("CPF já cadastrado");
        }
        if (clienteDTO.getTelefone() != null){
            throw new RuntimeException("Telefone já cadastrado");

//        Cliente cliente = mapper.dtoToEntity(clienteDTO);
//        repository.save(cliente);
//        ClienteDTO clienteDTO1 = mapper.entityToDTO(cliente);

    }
        return clienteDTO;
    }

    public void deletarCliente(Long id) {
        repository.deleteById(id);
    }

//    public ClienteDTO buscarPorId(Long id) {
//        Cliente cliente = repository.buscarPorId(id);
//    }
}
