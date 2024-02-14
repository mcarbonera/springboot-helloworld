package com.teste.testeescreveunaoleuopaucomeu.configurations;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.teste.testeescreveunaoleuopaucomeu.dtos.commons.ErroDTO;
import com.teste.testeescreveunaoleuopaucomeu.exceptions.NegocioException;

@RestControllerAdvice
public class ResourceExceptionHandler {
    
    private MessageSource messageSource;

    public ResourceExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ResponseStatus(code = HttpStatus.EXPECTATION_FAILED)
    @ExceptionHandler(IllegalArgumentException.class)
    public ErroDTO handle(IllegalArgumentException exception) {
        return new ErroDTO(messageSource
                .getMessage(exception.getMessage(), null, LocaleContextHolder.getLocale()));
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<ErroDTO> handle(NegocioException exception) {
        return ResponseEntity
            .status(exception.getHttpStatusCode())
            .body(new ErroDTO(messageSource.getMessage(
                exception.getMessage(), null, LocaleContextHolder.getLocale())));
    }
}