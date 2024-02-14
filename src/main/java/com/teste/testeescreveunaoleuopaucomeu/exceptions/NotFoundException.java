package com.teste.testeescreveunaoleuopaucomeu.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends NegocioException {
    
    public NotFoundException(String nomeEntidade) {
        super(nomeEntidade + ".notfound", HttpStatus.NOT_FOUND);
    }

    public NotFoundException() {
        super();
    }
}