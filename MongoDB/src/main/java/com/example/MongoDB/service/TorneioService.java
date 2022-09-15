package com.example.MongoDB.service;

import com.example.MongoDB.model.PartidaModel;
import com.example.MongoDB.model.TorneiroModel;
import com.example.MongoDB.repository.TorneioRepository;
import com.example.MongoDB.sequence.SequenceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorneioService {

    @Autowired
    private SequenceDao sequenceDao;

    private static final String TORNEIO_SEQ_KEY = "torneio";

    private TorneioRepository torneioRepository;

    public TorneioService(TorneioRepository torneioRepository) {
        this.torneioRepository = torneioRepository;
    }

    public TorneiroModel adicionar(TorneiroModel torneiroModel){
        torneiroModel.setId(sequenceDao.getNextSequenceId(TORNEIO_SEQ_KEY));
        return torneioRepository.save(torneiroModel);
    }

    public TorneiroModel alterar(TorneiroModel torneiroModel){
        if (torneioRepository.existsById(torneiroModel.getId())) {
            return torneioRepository.save(torneiroModel);
        }
        return null;
    }

    public List<TorneiroModel> listarTorneios(){
        return torneioRepository.findAll();
    }
}
