package com.example.gestaodevendas.service;

import com.example.gestaodevendas.domain.dto.CategoriaDTO;
import com.example.gestaodevendas.domain.entity.Categoria;
import com.example.gestaodevendas.domain.exceptions.DataBaseException;
import com.example.gestaodevendas.domain.exceptions.NotFoundException;
import com.example.gestaodevendas.domain.mapper.CategoriaMapper;
import com.example.gestaodevendas.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;
    private final CategoriaMapper mapper;

    public CategoriaDTO salvar(CategoriaDTO categoriaDTO) {

        Categoria categoria = mapper.dtoToEntity(categoriaDTO);
        try {
            repository.save(categoria);
        } catch (Exception ex){
            throw new DataBaseException("Erro ao acessar o banco de dados");
        }
        return mapper.entityToDTO(categoria);
    }

    public CategoriaDTO buscarPorId(Long id) {
        Categoria categoria =repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
        return mapper.entityToDTO(categoria);
    }

    public void deletarCliente(Long id) {
        CategoriaDTO categoriaDTO = buscarPorId(id);
        mapper.dtoToEntity(categoriaDTO);
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
