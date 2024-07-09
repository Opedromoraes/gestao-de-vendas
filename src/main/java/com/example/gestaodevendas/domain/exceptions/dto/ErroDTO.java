package com.example.gestaodevendas.domain.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ErroDTO{

    private final String message;
    private final List<String> errors;

}
