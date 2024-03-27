package com.company.store.infrastructure.mongo.reword.service;

import com.company.store.infrastructure.mongo.reword.repository.RewordGroupMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RewordGroupMongoService {

    private final RewordGroupMongoRepository rewordGroupMongoRepository;

    public RewordGroupMongoService(
            RewordGroupMongoRepository rewordGroupMongoRepository
    ) {
        this.rewordGroupMongoRepository = rewordGroupMongoRepository;
    }
}
