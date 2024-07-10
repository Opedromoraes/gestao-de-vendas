package com.example.gestaodevendas.domain.exceptions;

public class DataBaseException extends BaseException {

    public DataBaseException(String message) {
        super(message);
    }

    public DataBaseException(String message, Throwable cause) {
        super(message, cause);
    }

//    public DataBaseException(String message, List<String> errors) {
//        super(message, errors, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
//    }
//
//    public DataBaseException(String message) {
//        super(message, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
//    }
//
//    public DataBaseException(String message, Throwable e) {
//        super(message, e, HttpStatusCode.valueOf(HttpStatus.BAD_REQUEST.value()));
//    }
}
