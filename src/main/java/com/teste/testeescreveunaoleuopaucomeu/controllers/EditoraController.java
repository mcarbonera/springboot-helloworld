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

import com.teste.testeescreveunaoleuopaucomeu.dtos.EditoraDto;
import com.teste.testeescreveunaoleuopaucomeu.model.Editora;
import com.teste.testeescreveunaoleuopaucomeu.services.EditoraService;

@Controller
@RequestMapping("/livraria/editora")
public class EditoraController {
    
    private EditoraService editoraService;

    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

    @PostMapping
    public ResponseEntity<Editora> saveEditora(@RequestBody EditoraDto editoraDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(editoraService.saveEditora(editoraDto));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Editora> updateEditora(@PathVariable Long id, @RequestBody EditoraDto editoraDto) {
        return ResponseEntity.ok().body(editoraService.updateEditora(id, editoraDto));
    }

    @GetMapping
    public ResponseEntity<Collection<Editora>> getAllEditoras() {
        return ResponseEntity.ok().body(editoraService.getAllEditoras());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Editora> getEditoraById(@PathVariable Long id) {
        return ResponseEntity.ok().body(editoraService.getEditoraById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteEditoraById(@PathVariable Long id) {
        return ResponseEntity.ok().body(editoraService.deleteEditoraById(id));
    }
}