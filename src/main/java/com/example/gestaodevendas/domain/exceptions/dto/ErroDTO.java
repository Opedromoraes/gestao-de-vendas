package com.example.gestaodevendas.domain.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ErroDTO extends RuntimeException{

    private final List<String> errors;

    public ErroDTO(String message, List<String> errors) {
        super(message);
        this.errors = errors;
    }
}
