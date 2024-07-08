package com.example.gestaodevendas.service;

import com.example.gestaodevendas.domain.dto.CategoriaDTO;
import com.example.gestaodevendas.domain.dto.ClienteDTO;
import com.example.gestaodevendas.domain.entity.Categoria;
import com.example.gestaodevendas.domain.entity.Cliente;
import com.example.gestaodevendas.domain.mapper.CategoriaMapper;
import com.example.gestaodevendas.domain.mapper.ClienteMapper;
import com.example.gestaodevendas.repository.CategoriaRepository;
import com.example.gestaodevendas.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaDTO salvar(CategoriaDTO categoriaDTO) {

        Categoria categoria = mapper.dtoToEntity(categoriaDTO);
        repository.save(categoria);
        return mapper.entityToDTO(categoria);
    }

    public CategoriaDTO buscarPorId(Long id) {
        Categoria categoria =repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        return mapper.entityToDTO(categoria);
    }

    public void deletarCliente(Long id) {
        repository.deleteById(id);
    }
}

//
//    public ClienteDTO verificarCliente(Long id,ClienteDTO clienteDTO) {
//        Cliente clienteEncontrado = repository.findByEmail(clienteDTO.getEmail());
//
//        if (clienteEncontrado != null && !clienteEncontrado.getIdCliente().equals(id)) {
//            throw new RuntimeException("Email já cadastrado");
//        }
//        clienteEncontrado = repository.findByCpf(clienteDTO.getCpf());
//
//        if (clienteEncontrado != null && !clienteEncontrado.getIdCliente().equals(id)) {
//            throw new RuntimeException("CPF já cadastrado");
//        }
//
//        clienteEncontrado = repository.findByTelefone(clienteDTO.getTelefone());
//
//        if (clienteEncontrado != null && !clienteEncontrado.getIdCliente().equals(id)) {
//            throw new RuntimeException("Telefone já cadastrado");
//        }
//
//        return mapper.entityToDTO(clienteEncontrado);
//    }

//}
