package com.dh.MesaTrabalho32.repository;

import com.dh.MesaTrabalho32.entity.ProdutosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProdutosRepository extends JpaRepository<ProdutosEntity, Long> {
}
