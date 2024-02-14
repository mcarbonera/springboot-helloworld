package com.teste.testeescreveunaoleuopaucomeu.model;

import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "LIVRO")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "editora_id", foreignKey = @ForeignKey(name = "fk_livro_editora"))
    private Editora editora;

    @ManyToMany
    @JoinTable(name = "autor_livro", 
        joinColumns = @JoinColumn(name = "livro_id", foreignKey = @ForeignKey(name = "fk_relation_livro")), 
        inverseJoinColumns = @JoinColumn(name = "autor_id"), foreignKey = @ForeignKey(name = "fk_relation_autor"))
    private Collection<Autor> autores;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Editora getEditora() {
        return this.editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public Collection<Autor> getAutores() {
        return this.autores;
    }

    public void setAutores(Collection<Autor> autores) {
        this.autores = autores;
    }
}