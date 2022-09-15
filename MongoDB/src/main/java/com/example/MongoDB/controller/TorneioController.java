package com.example.MongoDB.controller;

import com.example.MongoDB.model.TorneiroModel;
import com.example.MongoDB.service.TorneioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torneios")
public class TorneioController {

    private TorneioService torneioService;

    public TorneioController(TorneioService torneioService){
        this.torneioService = torneioService;
    }

    @PostMapping
    public TorneiroModel adicionarTorneio(@RequestBody TorneiroModel torneiroModel){
        return torneioService.adicionar(torneiroModel);
    }

    @GetMapping
    public List<TorneiroModel> listarTorneios(){
        return torneioService.listarTorneios();
    }

    @PutMapping
    public TorneiroModel alterar(TorneiroModel torneiroModel){ return torneioService.alterar(torneiroModel);}

}
