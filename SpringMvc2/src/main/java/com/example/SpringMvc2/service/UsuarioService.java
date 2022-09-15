package com.example.SpringMvc2.service;

import com.example.SpringMvc2.model.Usuario;

public class UsuarioService {

    public Usuario criarUsuario(String nome, int idade){
        Usuario usuario = new Usuario(nome, idade);
        return usuario;
    }

}
