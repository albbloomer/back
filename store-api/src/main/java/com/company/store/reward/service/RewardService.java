package com.company.store.reward.service;

import com.company.store.infrastructure.mongo.reward.service.RewardGroupMongoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class RewardService {

    private static final Logger log = LoggerFactory.getLogger(RewardService.class);

    private final RewardGroupMongoService rewardGroupMongoService;

    public RewardService(
            RewardGroupMongoService rewardGroupMongoService
    ) {
        this.rewardGroupMongoService = rewardGroupMongoService;
    }

    // Todo : GROUP -> MISSION -> QUEST 전부 가져오기
    public void getGroupAll() {
        rewardGroupMongoService.getAllRewardGroups();
    }
}
