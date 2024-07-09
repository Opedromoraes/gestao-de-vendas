package com.example.gestaodevendas.domain.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public class DataBaseException extends BaseException {

    public DataBaseException(String message, List<String> errors) {
        super(message, errors, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }

    public DataBaseException(String message) {
        super(message, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }

    public DataBaseException(String message, Throwable e) {
        super(message, e, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
    }
}
