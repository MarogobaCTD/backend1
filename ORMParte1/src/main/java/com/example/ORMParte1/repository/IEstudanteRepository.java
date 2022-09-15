package com.example.ORMParte1.repository;

import com.example.ORMParte1.entity.EstudanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEstudanteRepository extends JpaRepository<EstudanteEntity, Long> {
}
