package com.example.gestaodevendas.domain.exceptions;

import lombok.Getter;

@Getter
public class BusinessException extends BaseException {

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

//    public BusinessException(String message, Object... args) {
//        super(message, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()), args);
//    }
//
//    public BusinessException(String message) {
//        super(message, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
//    }
//
//    public BusinessException(String message, Throwable e) {
//        super(message, e, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
//    }

}
