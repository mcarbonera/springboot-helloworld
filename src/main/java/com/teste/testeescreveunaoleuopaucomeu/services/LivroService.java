package com.teste.testeescreveunaoleuopaucomeu.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teste.testeescreveunaoleuopaucomeu.dtos.LivroDto;
import com.teste.testeescreveunaoleuopaucomeu.exceptions.NotFoundException;
import com.teste.testeescreveunaoleuopaucomeu.model.Livro;
import com.teste.testeescreveunaoleuopaucomeu.repositories.AutorRepository;
import com.teste.testeescreveunaoleuopaucomeu.repositories.EditoraRepository;
import com.teste.testeescreveunaoleuopaucomeu.repositories.LivroRepository;

@Service
public class LivroService {
    
    private static final String LIVRO_NOT_FOUND = "livro";
    private static final String EDITORA_NOT_FOUND = "editora";
    private static final String AUTOR_NOT_FOUND = "autor";

    private LivroRepository livroRepository;
    private EditoraRepository editoraRepository;
    private AutorRepository autorRepository;

    public LivroService(LivroRepository livroRepository,
                        EditoraRepository editoraRepository,
                        AutorRepository autorRepository) {
        this.livroRepository = livroRepository;
        this.editoraRepository = editoraRepository;
        this.autorRepository = autorRepository;
    }

    private Livro getLivroEntityToPersist(LivroDto livroDto) {
        Livro livro = new Livro();
        BeanUtils.copyProperties(livroDto, livro);
        
        var editora = editoraRepository.findById(livroDto.idEditora())
            .orElseThrow(() -> new NotFoundException(EDITORA_NOT_FOUND));
        livro.setEditora(editora);

        var autores = autorRepository.findAllById(livroDto.idsAutores());
        if(autores.size() < livroDto.idsAutores().size()) {
            throw new NotFoundException(AUTOR_NOT_FOUND);
        }
        livro.setAutores(autores);
        return livro;
    }

    public Livro saveLivro(LivroDto livroDto) {
        Livro livro = getLivroEntityToPersist(livroDto);
        return livroRepository.save(livro);
    }

    public Livro updateLivro(Long id, LivroDto livroDto) {
        Livro livro = getLivroEntityToPersist(livroDto);
        livro.setId(id);
        return livroRepository.save(livro);
    }

    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    public Livro getLivroById(Long id) {
        return livroRepository.findById(id)
            .orElseThrow(() -> new NotFoundException(LIVRO_NOT_FOUND));
    }

    public Long deleteLivroById(Long id) {
        this.getLivroById(id); // para dar erro se não existir.
        livroRepository.deleteById(id);
        return id;
    }
}