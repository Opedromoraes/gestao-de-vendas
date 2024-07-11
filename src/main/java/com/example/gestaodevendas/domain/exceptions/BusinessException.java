package com.example.gestaodevendas.domain.exceptions;

import com.example.gestaodevendas.domain.exceptions.dto.ErroDTO;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class BusinessException extends BaseException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, ErroDTO erro, HttpStatusCode status) {
        super(message, erro, status);
    }

    public BusinessException(ErroDTO erro, HttpStatusCode status) {
        super(erro, status);
    }
}
