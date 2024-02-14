package com.teste.testeescreveunaoleuopaucomeu.dtos.commons;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonPropertyOrder({"success", "message", "erro", "data", "paginacao"})
public class ResponseBase<T> {
    private String message;
    private T data;
    private PaginacaoBase paginacao;
    @JsonUnwrapped
    private ErroDTO erro;

    public static <T> ResponseBase<T> of(final T data) {
        final var response = new ResponseBase<T>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static <T> ResponseBase<List<T>> ofPage(Page<T> page) {
        PaginacaoBase paginacaoBase = new PaginacaoBase();
        paginacaoBase.setPagina(page.getNumber());
        paginacaoBase.setTamanhoPagina(page.getSize());
        paginacaoBase.setTotalPaginas(page.getTotalPages());
        paginacaoBase.setTotalRegistros((int) page.getTotalElements());
    
        ResponseBase<List<T>> responseBase = new ResponseBase<List<T>>();
        responseBase.setData(page.getContent());
        responseBase.setSuccess(true);
        responseBase.setPaginacao(paginacaoBase);
    
        return responseBase;
    }

    public ResponseEntity<ResponseBase<T>> buildResponse(HttpStatus httpStatus) {
        return ResponseEntity
            .status(httpStatus)
            .body(this);
    }

    public static <T> ResponseEntity<ResponseBase<T>> buildError(String mensagem, HttpStatus httpStatus) {
        final var response = new ResponseBase<T>();
        response.setErroMessage(mensagem);
        return ResponseEntity
            .status(httpStatus)
            .body(response);
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public PaginacaoBase getPaginacao() {
        return this.paginacao;
    }

    public void setPaginacao(PaginacaoBase paginacao) {
        this.paginacao = paginacao;
    }

    public ErroDTO getErro() {
        return this.erro;
    }

    public void setErro(ErroDTO erro) {
        this.erro = erro;
    }

    public boolean isSuccess() {
        return this.getErro().getSuccess();
    }

    public boolean getSuccess() {
        return this.getErro().getSuccess();
    }

    public void setSuccess(boolean success) {
        this.getErro().setSuccess(success);
    }

    public String getErroMessage() {
        return this.getErro().getErro();
    }

    public void setErroMessage(String erro) {
        this.getErro().setErro(erro);
    }
}