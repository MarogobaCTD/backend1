package com.example.dentista.controller;

import com.example.dentista.model.Dentista;
import com.example.dentista.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("dentistas")
public class DentistaController {

    private final DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService){
        this.dentistaService = dentistaService;
    }

    @GetMapping
    public List<Dentista> getDentistas(){
        return dentistaService.listaDentista();
    }

}
