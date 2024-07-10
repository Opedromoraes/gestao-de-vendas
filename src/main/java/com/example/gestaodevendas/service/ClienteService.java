package com.example.gestaodevendas.service;

import com.example.gestaodevendas.domain.dto.ClienteDTO;
import com.example.gestaodevendas.domain.entity.Cliente;
import com.example.gestaodevendas.domain.exceptions.BusinessException;
import com.example.gestaodevendas.domain.mapper.ClienteMapper;
import com.example.gestaodevendas.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;


    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        Cliente cliente = mapper.dtoToEntity(clienteDTO);
        cliente = repository.save(cliente);

        return mapper.entityToDTO(cliente);
    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        ClienteDTO clienteAntigoDTO = buscarPorId(id);
        verificarCliente(clienteDTO);

        Cliente cliente = mapper.dtoToEntity(clienteAntigoDTO);

        cliente.setCpf(clienteDTO.getCpf());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());

        return mapper.entityToDTO(repository.save(cliente));
    }


    public ClienteDTO verificarCliente(ClienteDTO clienteDTO) {
        Optional<Cliente> clienteOpt = repository.findByEmail(clienteDTO.getEmail());
        clienteOpt.orElseThrow(() -> new BusinessException("Email já cadastrado"));

        repository.findByCpf(clienteDTO.getCpf());
        clienteOpt.orElseThrow(() -> new BusinessException("CPF já cadastrado"));

        repository.findByTelefone(clienteDTO.getTelefone());
        clienteOpt.orElseThrow(() -> new BusinessException("Telefone já cadastrado"));

        return mapper.entityToDTO(clienteOpt.get());
    }

    public void deletarCliente(Long id) {
        repository.deleteById(id);
    }

    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = repository.findById(id).get();
        return mapper.entityToDTO(cliente);
    }
}
