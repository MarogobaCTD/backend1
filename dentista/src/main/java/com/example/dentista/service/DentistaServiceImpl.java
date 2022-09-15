package com.example.dentista.service;

import com.example.dentista.model.Dentista;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
@Service
public class DentistaServiceImpl implements DentistaService{

    @Override
    public List<Dentista> listaDentista() {
        return Arrays.asList(new Dentista("Maria"), new Dentista("Joao"));
    }
}
