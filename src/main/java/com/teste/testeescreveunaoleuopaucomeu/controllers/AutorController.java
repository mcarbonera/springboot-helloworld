package com.teste.testeescreveunaoleuopaucomeu.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teste.testeescreveunaoleuopaucomeu.dtos.AutorDto;
import com.teste.testeescreveunaoleuopaucomeu.model.Autor;
import com.teste.testeescreveunaoleuopaucomeu.services.AutorService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/livraria/autor")
public class AutorController {

    private AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @PostMapping
    public ResponseEntity<Autor> saveAutor(@RequestBody AutorDto autorDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.saveAutor(autorDto));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Autor> updateAutor(@PathVariable Long id, @RequestBody AutorDto autorDto) {
        return ResponseEntity.ok().body(autorService.updateAutor(id, autorDto));
    }

    @GetMapping
    public ResponseEntity<Collection<Autor>> getAllAutores() {
        return ResponseEntity.ok().body(autorService.getAllAutores());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Autor> getAutorById(@PathVariable Long id) {
        return ResponseEntity.ok().body(autorService.getAutorById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteAutorById(@PathVariable Long id) {
        return ResponseEntity.ok().body(autorService.deleteAutorById(id));
    }
}