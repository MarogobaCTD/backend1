package com.dh.MesaTrabalho32.controller;

import com.dh.MesaTrabalho32.entity.ProdutosEntity;
import com.dh.MesaTrabalho32.service.impl.ProdutosServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutosController {

    private final ProdutosServiceImpl produtosService;

    public ProdutosController(ProdutosServiceImpl produtosService) {
        this.produtosService = produtosService;
    }

    @PostMapping("/produtos")
    public ProdutosEntity addProdutos(ProdutosEntity produtosEntity){
        return produtosService.addProdutos(produtosEntity);
    }

}
