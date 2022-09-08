package com.dh.MesaTrabalho32.service;

import com.dh.MesaTrabalho32.entity.ProdutosEntity;

import java.util.List;
import java.util.Optional;

public interface IProdutosService<T> {

    public T addProdutos(T t);
    public List<T> findAllProdutos();
    public Optional<T> findProdutos(Long id);
    public String deleteProdutos(Long id);
    public String updateProdutos(T t);

}
