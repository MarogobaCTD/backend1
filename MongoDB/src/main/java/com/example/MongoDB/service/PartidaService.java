package com.example.MongoDB.service;

import com.example.MongoDB.model.EstadoModel;
import com.example.MongoDB.model.PartidaModel;
import com.example.MongoDB.repository.PartidaRepository;
import com.example.MongoDB.sequence.SequenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    @Autowired
    private SequenceDao sequenceDao;

    private static final String PARTIDA_SEQ_KEY = "partida";
    private static final String EQUIPE_SEQ_KEY = "equipe";

    private PartidaRepository partidaRepository;

    public PartidaService(PartidaRepository partidaRepository){
        this.partidaRepository = partidaRepository;
    }

    public PartidaModel adicionar(PartidaModel partida){

        partida.setId(sequenceDao.getNextSequenceId(PARTIDA_SEQ_KEY));
        partida.getEquipeLocal().setId(sequenceDao.getNextSequenceId(EQUIPE_SEQ_KEY));
        partida.getEquipeVisitante().setId(sequenceDao.getNextSequenceId(EQUIPE_SEQ_KEY));
        return partidaRepository.save(partida);
    }

    public List<PartidaModel> listar(){
        return partidaRepository.findAll();
    }

    public List<PartidaModel> partidaAoVivo(){
        return partidaRepository.findAllByEstado(EstadoModel.AO_VIVO);
    }

}
