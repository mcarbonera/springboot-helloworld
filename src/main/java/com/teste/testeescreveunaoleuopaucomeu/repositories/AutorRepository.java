package com.teste.testeescreveunaoleuopaucomeu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.testeescreveunaoleuopaucomeu.model.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    
}