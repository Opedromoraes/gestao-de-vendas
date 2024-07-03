package com.example.gestaodevendas.service;

import com.example.gestaodevendas.domain.dto.ClienteDTO;
import com.example.gestaodevendas.domain.entity.Cliente;
import com.example.gestaodevendas.domain.mapper.ClienteMapper;
import com.example.gestaodevendas.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;
    private final ClienteMapper mapper;


    public ClienteDTO salvar(ClienteDTO clienteDTO) {
        verificarCliente(null,clienteDTO);
        Cliente cliente = mapper.dtoToEntity(clienteDTO);
        cliente = repository.save(cliente);
        return mapper.entityToDTO(cliente);

    }

    public ClienteDTO atualizarCliente(Long id, ClienteDTO clienteDTO) {
        ClienteDTO clienteAntigoDTO = buscarPorId(id);
        verificarCliente(id, clienteDTO);

        Cliente cliente = mapper.dtoToEntity(clienteAntigoDTO);

        cliente.setCpf(clienteDTO.getCpf());
        cliente.setNome(clienteDTO.getNome());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());

        return mapper.entityToDTO(repository.save(cliente));
    }

//    public ClienteDTO verificarClienteCriado(ClienteDTO clienteDTO) {
//        if (!repository.findByEmail(clienteDTO.getEmail()).isEmpty()) {
//            throw new RuntimeException("Email já cadastrado");
//        }
//        if (!repository.findByTelefone(clienteDTO.getTelefone()).isEmpty()) {
//            throw new RuntimeException("Telefone já cadastrado");
//        }
//        if (!repository.findByCpf(clienteDTO.getCpf()).isEmpty()) {
//            throw new RuntimeException("CPF já cadastrado");
//        }
//        return clienteDTO;
//    }

    public ClienteDTO verificarCliente(Long id,ClienteDTO clienteDTO) {
        Cliente clienteEncontrado = repository.findByEmail(clienteDTO.getEmail());

        if (clienteEncontrado != null && !clienteEncontrado.getIdCliente().equals(id)) {
            throw new RuntimeException("Email já cadastrado");
        }
        clienteEncontrado = repository.findByCpf(clienteDTO.getCpf());

        if (clienteEncontrado != null && !clienteEncontrado.getIdCliente().equals(id)) {
            throw new RuntimeException("CPF já cadastrado");
        }

        clienteEncontrado = repository.findByTelefone(clienteDTO.getTelefone());

        if (clienteEncontrado != null && !clienteEncontrado.getIdCliente().equals(id)) {
            throw new RuntimeException("Telefone já cadastrado");
        }

        return mapper.entityToDTO(clienteEncontrado);
    }

    public void deletarCliente(Long id) {
        repository.deleteById(id);
    }

    public ClienteDTO buscarPorId(Long id) {
        Cliente cliente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return mapper.entityToDTO(cliente);
    }
}
