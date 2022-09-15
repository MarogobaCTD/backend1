package com.example.esporteHQL.service;

import com.example.esporteHQL.model.JogadorModel;
import com.example.esporteHQL.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private JogadorRepository jogadorRepository;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository){
        this.jogadorRepository = jogadorRepository;
    }

    public List<JogadorModel> buscarTodos(){
        return jogadorRepository.findAll();
    }

    public JogadorModel buscarPorNome(String nome){
        return jogadorRepository.findJogadorByName(nome).get();
    }

}
