package com.example.gestaodevendas.domain.exceptions;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException{

//    private final ErroDTO erro;
//    private final HttpStatusCode status;

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

//    public BaseException(String message,ErroDTO erro, HttpStatusCode httpStatusCode) {
//        super(message);
//        this.status = httpStatusCode;
//        this.erro = erro;
//    }
//
//    public BaseException(String message, HttpStatusCode httpStatusCode) {
//        super(message);
//        this.status = httpStatusCode;
//        this.errors = null;
//    }
//
//    public BaseException(String message, Throwable e, HttpStatusCode httpStatusCode) {
//        super(message, e);
//        this.status = httpStatusCode;
//        this.errors = null;
//    }
//
//    public BaseException(String message,HttpStatusCode httpStatusCode,Object[] args) {
//        super(String.format(message,args));
//        this.status = httpStatusCode;
//        this.errors = null;
//    }
}
