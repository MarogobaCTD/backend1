package com.example.esporteHQL.repository;

import com.example.esporteHQL.model.JogadorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JogadorRepository extends JpaRepository<JogadorModel, Long> {

    @Query("Select jogador j from Jogador where j.nome = ?1")
    Optional<JogadorModel> findJogadorByName(String name);


}
