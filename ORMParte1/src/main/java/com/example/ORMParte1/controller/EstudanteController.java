package com.example.ORMParte1.controller;

import com.example.ORMParte1.entity.EstudanteEntity;
import com.example.ORMParte1.service.impl.EstudanteServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EstudanteController {

    private final EstudanteServiceImpl estudanteService;

    public EstudanteController(EstudanteServiceImpl estudanteService) {
        this.estudanteService = estudanteService;
    }

    @RequestMapping(value = "/estudantes", method = RequestMethod.GET, produces = "application/json")
    public List<EstudanteEntity> buscarTodosEstudantes(){
        return estudanteService.findAllEstudantes();
    }

    @GetMapping("/estudantes/{id}")
    public Optional<EstudanteEntity> buscarEstudantePorId(@PathVariable Long id){
        return estudanteService.findEstudantes(id);
    }

    @PostMapping("/estudantes/adicionar")
    public EstudanteEntity adicionarEstudante(@RequestBody EstudanteEntity estudanteEntity){
        return estudanteService.addEstudante(estudanteEntity);
    }

    @DeleteMapping("/estudantes/delete/{id}")
    public String deletarEstudante(@PathVariable Long id){
        return estudanteService.deleteEstudante(id);
    }

    @PutMapping("/estudantes/atualizar")
    public String atualizarEstudante(@RequestBody EstudanteEntity estudanteEntity){
        return estudanteService.updateEstudante(estudanteEntity);
    }







}
