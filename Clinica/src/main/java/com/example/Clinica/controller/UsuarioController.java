package com.example.Clinica.controller;

import com.example.Clinica.model.Usuario;
import com.example.Clinica.service.UsuarioService;
import com.example.Clinica.service.imp.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController

public class UsuarioController {

    private final UsuarioServiceImp usuarioService;

    public UsuarioController(UsuarioServiceImp usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Autowired

    @GetMapping(value = "/cadastro")
    public List<Usuario> cadastrar() {
        return usuarioService.cadastrar();
    }

    @RequestMapping(value = "/buscar", method = RequestMethod.GET)
    public Usuario buscar(Model model, @RequestParam("id") Integer id) {
        return usuarioService.buscar(id);
    }

    @RequestMapping(value = "/deletar", method = RequestMethod.GET)
    public String deletar(Model model, @RequestParam("id") Integer id){
        return usuarioService.deletar(id);
    }

    @PostMapping("/salvar")
    public Usuario salvar(@RequestBody Usuario usuario){
        return usuarioService.salvar(usuario);
    }

    @PutMapping("/atualizar")
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario) throws SQLException {
        ResponseEntity responseEntity = null;

        if(usuarioService.buscar(usuario.getId())==null){
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            responseEntity = new ResponseEntity(usuarioService.atualizar(usuario), HttpStatus.OK);
        }
        return responseEntity;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> apagar(@PathVariable Integer id) throws SQLException {
        ResponseEntity responseEntity = null;

        if(usuarioService.buscar(id)==null){
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        } else {
            usuarioService.deletar(id);
            responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return responseEntity;
    }

}
