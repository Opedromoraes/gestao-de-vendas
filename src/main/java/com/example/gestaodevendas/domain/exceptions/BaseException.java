package com.example.gestaodevendas.domain.exceptions;

import com.example.gestaodevendas.domain.exceptions.dto.ErroDTO;
import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class BaseException extends RuntimeException{

    private final ErroDTO erro;
    private final HttpStatusCode status;

    public BaseException(String message) {
        super(message);
        this.erro = null;
        this.status = null;
    }

    public BaseException(String message, ErroDTO erro, HttpStatusCode status) {
        super(message);
        this.erro = erro;
        this.status = status;
    }


    public BaseException(ErroDTO erro, HttpStatusCode status) {
        this.erro = erro;
        this.status = status;
    }

}
