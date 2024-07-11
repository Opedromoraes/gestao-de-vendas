package com.example.gestaodevendas.domain.exceptions;

import com.example.gestaodevendas.domain.exceptions.dto.ErroDTO;
import org.springframework.http.HttpStatusCode;

public class NotFoundException extends BaseException{

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, ErroDTO erro, HttpStatusCode status) {
        super(message, erro, status);
    }

    public NotFoundException(ErroDTO erro, HttpStatusCode status) {
        super(erro, status);
    }
}
