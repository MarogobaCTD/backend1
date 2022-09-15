package com.example.esporteHQL.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Treinador")
public class TreinadorModel {

    @Id
    @SequenceGenerator(name = "treinador_sequence", sequenceName = "treinador_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treinador_sequence")
    private Long id;
    private String nome;
    private int idade;

    @OneToMany(mappedBy = "treinadorModel", fetch = FetchType.LAZY)
    public Set<JogadorModel> jogadorModel = new HashSet<JogadorModel>();

    public TreinadorModel(){}

    public TreinadorModel(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Set<JogadorModel> getJogadorModel() {
        return jogadorModel;
    }

    public void setJogadorModel(Set<JogadorModel> jogadorModel) {
        this.jogadorModel = jogadorModel;
    }
}
