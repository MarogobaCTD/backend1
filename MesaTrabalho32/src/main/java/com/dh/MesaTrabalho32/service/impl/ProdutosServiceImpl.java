package com.dh.MesaTrabalho32.service.impl;

import com.dh.MesaTrabalho32.entity.ProdutosEntity;
import com.dh.MesaTrabalho32.repository.IProdutosRepository;
import com.dh.MesaTrabalho32.service.IProdutosService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutosServiceImpl implements IProdutosService<ProdutosEntity> {

    private final IProdutosRepository produtosRepository;

    public ProdutosServiceImpl(IProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    @Override
    public ProdutosEntity addProdutos(ProdutosEntity produtosEntity){
        if (produtosEntity != null){
            return produtosRepository.save(produtosEntity);
        }
        return new ProdutosEntity();
    }

    @Override
    public List<ProdutosEntity> findAllProdutos() {
        return produtosRepository.findAll();
    }

    @Override
    public Optional<ProdutosEntity> findProdutos(Long id) {
        return produtosRepository.findById(id);
    }

    @Override
    public String deleteProdutos(Long id) {
        if (produtosRepository.findById(id).isPresent()){
            produtosRepository.deleteById(id);
            return "Produto apagado";
        }
        return "Produto não encontrado!";
    }

    @Override
    public String updateProdutos(ProdutosEntity produtosEntity) {
        if (produtosEntity != null && produtosRepository.findById(produtosEntity.getId()).isPresent()){
            produtosRepository.saveAndFlush(produtosEntity);
            return "Produto atualizado";
        }
        return "Produto não encontrado";
    }


}
