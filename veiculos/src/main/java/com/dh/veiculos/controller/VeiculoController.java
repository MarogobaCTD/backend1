package com.dh.veiculos.controller;

import com.dh.veiculos.model.Veiculo;
import com.dh.veiculos.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/listaVeiculos")
public class VeiculoController {

    private final VeiculoService veiculoService;

    @Autowired
    public VeiculoController(VeiculoService veiculoService){
        this.veiculoService = veiculoService;
    }

    @GetMapping
    public List<Veiculo> getVeiculos(){
        return veiculoService.listaVeiculos();
    }
}
