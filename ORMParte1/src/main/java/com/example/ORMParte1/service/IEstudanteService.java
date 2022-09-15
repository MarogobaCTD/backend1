package com.example.ORMParte1.service;

import com.example.ORMParte1.entity.EstudanteEntity;

import java.util.List;
import java.util.Optional;

public interface IEstudanteService <T>{

    public List<EstudanteEntity> findAllEstudantes();
    public Optional<EstudanteEntity> findEstudantes(Long id);
    public T addEstudante(T t);
    public String deleteEstudante(Long id);
    public String updateEstudante(T t);
}
