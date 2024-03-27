package com.company.store.infrastructure.mongo.reward.service;

import com.company.store.infrastructure.mongo.reward.entity.RewardGroup;
import com.company.store.infrastructure.mongo.reward.repository.RewardGroupMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RewardGroupMongoService {

    private final RewardGroupMongoRepository rewardGroupMongoRepository;

    public RewardGroupMongoService(
            RewardGroupMongoRepository rewardGroupMongoRepository
    ) {
        this.rewardGroupMongoRepository = rewardGroupMongoRepository;
    }

    public List<RewardGroup> getAllRewardGroups() {
        return rewardGroupMongoRepository.findAll();
    }
}
