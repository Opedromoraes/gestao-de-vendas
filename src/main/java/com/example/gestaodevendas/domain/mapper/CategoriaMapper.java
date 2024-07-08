package com.example.gestaodevendas.domain.mapper;

import com.example.gestaodevendas.api.controller.categoria.request.CategoriaRequest;
import com.example.gestaodevendas.api.controller.categoria.response.CategoriaResponse;
import com.example.gestaodevendas.domain.dto.CategoriaDTO;
import com.example.gestaodevendas.domain.entity.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

        CategoriaDTO entityToDTO(Categoria entity);

        Categoria dtoToEntity(CategoriaDTO dto);

        CategoriaDTO requestToDto(CategoriaRequest request);

        CategoriaResponse dtoToResponse(CategoriaDTO dto);

}
