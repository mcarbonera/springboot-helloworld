package com.teste.testeescreveunaoleuopaucomeu.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teste.testeescreveunaoleuopaucomeu.dtos.AutorDto;
import com.teste.testeescreveunaoleuopaucomeu.exceptions.NotFoundException;
import com.teste.testeescreveunaoleuopaucomeu.model.Autor;
import com.teste.testeescreveunaoleuopaucomeu.repositories.AutorRepository;

@Service
public class AutorService {

    private static final String AUTOR_NOT_FOUND = "autor";
    private AutorRepository autorRepository;

    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor saveAutor(AutorDto autorDto) {
        Autor autor = new Autor();
        BeanUtils.copyProperties(autorDto, autor);
        return autorRepository.save(autor);
    }

    public Autor updateAutor(Long id, AutorDto autorDto) {
        Autor autor = new Autor();
        BeanUtils.copyProperties(autorDto, autor);
        autor.setId(id);
        return autorRepository.save(autor);
    }

    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    public Autor getAutorById(Long id) {
        return autorRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(AUTOR_NOT_FOUND));
    }

    public Long deleteAutorById(Long id) {
        this.getAutorById(id); // para dar erro se não existir.
        autorRepository.deleteById(id);
        return id;
    }
}