package com.example.MongoDB.repository;

import com.example.MongoDB.model.TorneiroModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorneioRepository extends MongoRepository<TorneiroModel, Integer> {


}
