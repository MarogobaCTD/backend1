package com.example.SpringMvc2.controller;

import com.example.SpringMvc2.model.Usuario;
import com.example.SpringMvc2.service.UsuarioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
    private UsuarioService usuarioService = new UsuarioService();

    @GetMapping("/")
    public Usuario criarUsuario(){
        return usuarioService.criarUsuario("Diego", 24);
    }

    @GetMapping("criar2")
    public Usuario criarUsuario2(){
        return usuarioService.criarUsuario("Alicia", 45);
    }
}
