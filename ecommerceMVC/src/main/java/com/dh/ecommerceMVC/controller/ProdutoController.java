package com.dh.ecommerceMVC.controller;

import com.dh.ecommerceMVC.model.Produto;
import com.dh.ecommerceMVC.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService service;

    @PostMapping
    public Produto salvaProduto(@RequestBody Produto produto) throws SQLException {
        return service.salvar(produto);
    }

    @GetMapping
    public List<Produto> buscarTodos() throws SQLException{
        return service.buscarTodos();
    }

    @RequestMapping(value = "/buscaId")
    public Produto buscarPorId(@RequestParam("id") int id) throws SQLException{
        return service.buscarPorID(id).isEmpty() ? new Produto() : service.buscarPorID(id).get();
    }

    @PostMapping
    public void alterar(@RequestBody Produto produto) throws SQLException{
        System.out.println();
        service.alterar(produto);
    }

    @DeleteMapping
    public void excluir(@RequestParam("id") int id) throws SQLException{
        service.excluir(id);
    }

}
