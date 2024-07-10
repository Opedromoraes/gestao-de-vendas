package com.example.gestaodevendas.domain.exceptions;

public class NotFoundException extends BaseException{


    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

//    public NotFoundException(String message,Object... args) {
//        super(message, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()),args);
//    }
//
//    public NotFoundException(String message) {
//        super(message, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
//    }
//
//    public NotFoundException(String message, Throwable e) {
//        super(message, e, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
//    }

}
