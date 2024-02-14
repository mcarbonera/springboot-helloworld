package com.teste.testeescreveunaoleuopaucomeu.dtos;

import java.util.List;

public record LivroDto(
    String nome, String descricao, 
    Long idEditora, List<Long> idsAutores) {}