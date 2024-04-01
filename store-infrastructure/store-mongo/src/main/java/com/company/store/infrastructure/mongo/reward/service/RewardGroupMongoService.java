package com.company.store.infrastructure.mongo.reward.service;

import com.company.store.domain.reward.RewardGroup;
import com.company.store.infrastructure.mongo.mapper.RewardDomainMapper;
import com.company.store.infrastructure.mongo.reward.repository.RewardGroupMongoRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RewardGroupMongoService {

    private final RewardGroupMongoRepository rewardGroupMongoRepository;
    private final MongoTemplate mongoTemplate;
    public RewardGroupMongoService(
            RewardGroupMongoRepository rewardGroupMongoRepository,
            MongoTemplate mongoTemplate
    ) {
        this.rewardGroupMongoRepository = rewardGroupMongoRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<RewardGroup> getAllRewardGroups() {
        return rewardGroupMongoRepository.findAll()
                .stream()
                .map(RewardDomainMapper::toRewardGroupDomain)
                .toList();
    }
}
