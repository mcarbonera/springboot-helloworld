package com.teste.testeescreveunaoleuopaucomeu.dtos.commons;

import java.io.Serializable;

public class PaginacaoBase implements Serializable {
    
    private int pagina;
    private int tamanhoPagina;
    private int totalPaginas;
    private int totalRegistros;

    public int getPagina() {
        return this.pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getTamanhoPagina() {
        return this.tamanhoPagina;
    }

    public void setTamanhoPagina(int tamanhoPagina) {
        this.tamanhoPagina = tamanhoPagina;
    }

    public int getTotalPaginas() {
        return this.totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public int getTotalRegistros() {
        return this.totalRegistros;
    }

    public void setTotalRegistros(int totalRegistros) {
        this.totalRegistros = totalRegistros;
    }    
}