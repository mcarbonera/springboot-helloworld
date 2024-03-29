package com.teste.testeescreveunaoleuopaucomeu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.testeescreveunaoleuopaucomeu.model.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}