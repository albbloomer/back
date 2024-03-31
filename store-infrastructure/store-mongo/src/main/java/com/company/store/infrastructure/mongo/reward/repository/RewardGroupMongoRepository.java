package com.company.store.infrastructure.mongo.reward.repository;

import com.company.store.infrastructure.mongo.reward.entity.RewardGroupEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RewardGroupMongoRepository extends MongoRepository<RewardGroupEntity, String> {
    //
}
