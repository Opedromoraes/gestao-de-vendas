package com.example.gestaodevendas.domain.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

import java.util.List;

@Getter
public class BaseException extends RuntimeException{

    private final List<String> errors;
    private final HttpStatusCode status;


    public BaseException(String message, List<String> errors, HttpStatusCode httpStatusCode) {
        super(message);
        this.status = httpStatusCode;
        this.errors = errors;
    }

    public BaseException(String message, HttpStatusCode httpStatusCode) {
        super(message);
        this.status = httpStatusCode;
        this.errors = null;
    }

    public BaseException(String message, Throwable e, HttpStatusCode httpStatusCode) {
        super(message, e);
        this.status = httpStatusCode;
        this.errors = null;
    }

    public BaseException(String message,HttpStatusCode httpStatusCode,Object[] args) {
        super(String.format(message,args));
        this.status = httpStatusCode;
        this.errors = null;
    }
}
