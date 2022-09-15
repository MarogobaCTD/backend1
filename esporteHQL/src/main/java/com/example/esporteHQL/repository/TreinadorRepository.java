package com.example.esporteHQL.repository;

import com.example.esporteHQL.model.TreinadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TreinadorRepository extends JpaRepository<TreinadorModel, Long> {

    @Query("Select treinador j from Treinador where j.idade = ?1")
    Optional<TreinadorModel> findTreinadorbyIdade(Integer idade);
}
