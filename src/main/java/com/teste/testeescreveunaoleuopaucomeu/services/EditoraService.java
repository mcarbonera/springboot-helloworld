package com.teste.testeescreveunaoleuopaucomeu.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teste.testeescreveunaoleuopaucomeu.dtos.EditoraDto;
import com.teste.testeescreveunaoleuopaucomeu.exceptions.NotFoundException;
import com.teste.testeescreveunaoleuopaucomeu.model.Editora;
import com.teste.testeescreveunaoleuopaucomeu.repositories.EditoraRepository;

@Service
public class EditoraService {
    
    private static final String EDITORA_NOT_FOUND = "editora";
    private EditoraRepository editoraRepository;

    public EditoraService(EditoraRepository editoraRepository) {
        this.editoraRepository = editoraRepository;
    }

    public Editora saveEditora(EditoraDto editoraDto) {
        Editora editora = new Editora();
        BeanUtils.copyProperties(editoraDto, editora);
        return editoraRepository.save(editora);
    }

    public Editora updateEditora(Long id, EditoraDto editoraDto) {
        Editora editora = new Editora();
        BeanUtils.copyProperties(editoraDto, editora);
        editora.setId(id);
        return editoraRepository.save(editora);
    }

    public List<Editora> getAllEditoras() {
        return editoraRepository.findAll();
    }

    public Editora getEditoraById(Long id) {
        return editoraRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(EDITORA_NOT_FOUND));
    }

    public Long deleteEditoraById(Long id) {
        this.getEditoraById(id); // para dar erro se não existir.
        editoraRepository.deleteById(id);
        return id;
    }
}