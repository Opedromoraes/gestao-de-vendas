package com.example.gestaodevendas.domain.exceptions;

import com.example.gestaodevendas.domain.exceptions.dto.ErroDTO;
import org.springframework.http.HttpStatusCode;

public class DataBaseException extends BaseException {

    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(String message, ErroDTO erro, HttpStatusCode status) {
        super(message, erro, status);
    }

    public DataBaseException(ErroDTO erro, HttpStatusCode status) {
        super(erro, status);
    }
}
