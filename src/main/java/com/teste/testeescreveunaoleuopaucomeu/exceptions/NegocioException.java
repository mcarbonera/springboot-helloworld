package com.teste.testeescreveunaoleuopaucomeu.exceptions;

import org.springframework.http.HttpStatus;

public class NegocioException extends RuntimeException {
    
    private HttpStatus httpStatusCode;

    public NegocioException(String mensagemErro, HttpStatus httpStatusCode) {
        super(mensagemErro);
        this.httpStatusCode = httpStatusCode;
    }

    public NegocioException(String mensagemErro) {
        super(mensagemErro);
        this.httpStatusCode = HttpStatus.BAD_REQUEST;
    }

    public NegocioException() {
        super("erro.notfound");
        this.httpStatusCode = HttpStatus.BAD_REQUEST;
    }

    public HttpStatus getHttpStatusCode() {
        return this.httpStatusCode;
    }
}