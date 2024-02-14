package com.teste.testeescreveunaoleuopaucomeu.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teste.testeescreveunaoleuopaucomeu.dtos.LivroDto;
import com.teste.testeescreveunaoleuopaucomeu.model.Livro;
import com.teste.testeescreveunaoleuopaucomeu.services.LivroService;

@Controller
@RequestMapping("/livraria/livro")
public class LivroController {
    
    private LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> saveLivro(@RequestBody LivroDto livroDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.saveLivro(livroDto));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Livro> updateLivro(@PathVariable Long id, @RequestBody LivroDto livroDto) {
        return ResponseEntity.ok().body(livroService.updateLivro(id, livroDto));
    }

    @GetMapping
    public ResponseEntity<Collection<Livro>> getAllLivros() {
        return ResponseEntity.ok().body(livroService.getAllLivros());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroById(@PathVariable Long id) {
        return ResponseEntity.ok().body(livroService.getLivroById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteLivroById(@PathVariable Long id) {
        return ResponseEntity.ok().body(livroService.deleteLivroById(id));
    }
}