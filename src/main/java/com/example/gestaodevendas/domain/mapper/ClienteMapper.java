package com.example.gestaodevendas.domain.mapper;

import com.example.gestaodevendas.api.controller.cliente.request.ClienteRequest;
import com.example.gestaodevendas.api.controller.cliente.response.ClienteResponse;
import com.example.gestaodevendas.domain.dto.ClienteDTO;
import com.example.gestaodevendas.domain.entity.Cliente;
import org.mapstruct.Mapper;

import java.util.Optional;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

        ClienteDTO entityToDTO(Cliente entity);

        Cliente dtoToEntity(ClienteDTO dto);

        ClienteDTO requestToDto(ClienteRequest request);

        ClienteResponse dtoToResponse(ClienteDTO dto);

}
