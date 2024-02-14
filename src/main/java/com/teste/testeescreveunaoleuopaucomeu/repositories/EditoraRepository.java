package com.teste.testeescreveunaoleuopaucomeu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teste.testeescreveunaoleuopaucomeu.model.Editora;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
    
}