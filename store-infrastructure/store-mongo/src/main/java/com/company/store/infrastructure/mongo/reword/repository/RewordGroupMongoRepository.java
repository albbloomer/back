package com.company.store.infrastructure.mongo.reword.repository;

import com.company.store.infrastructure.mongo.reword.entity.RewordGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RewordGroupMongoRepository extends MongoRepository<RewordGroup, Long> {
    //
}
