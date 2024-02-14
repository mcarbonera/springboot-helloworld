package com.teste.testeescreveunaoleuopaucomeu.dtos.commons;

public class ErroDTO {
    
    private String erro;
    private boolean success;

    public ErroDTO(String erro) {
        this.erro = erro;
        this.success = false;
    }

    public String getErro() {
        return this.erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}