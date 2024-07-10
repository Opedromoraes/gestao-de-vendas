package com.example.gestaodevendas.domain.mapper;

import com.example.gestaodevendas.api.controller.produto.request.ProdutoRequest;
import com.example.gestaodevendas.api.controller.produto.response.ProdutoResponse;
import com.example.gestaodevendas.domain.dto.ProdutoDTO;
import com.example.gestaodevendas.domain.entity.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

        @Mapping(target = "idCategoria",source = "categoria.idCategoria")
        ProdutoDTO entityToDTO(Produto entity);
        Produto dtoToEntity(ProdutoDTO dto);
        ProdutoDTO requestToDto(ProdutoRequest request);
        ProdutoResponse dtoToResponse(ProdutoDTO dto);



}
