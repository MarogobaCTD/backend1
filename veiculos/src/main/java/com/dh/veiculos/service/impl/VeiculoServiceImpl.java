package com.dh.veiculos.service.impl;

import com.dh.veiculos.model.Veiculo;
import com.dh.veiculos.service.VeiculoService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {


    @Override
    public List<Veiculo> listaVeiculos() {
        return Arrays.asList(new Veiculo("Chevrolet", "Prata"), new Veiculo("Fiat", "Vermelho"), new Veiculo("Hyundai", "Preto"));
    }
}
