package com.company.store.infrastructure.mongo.mapper;

import com.company.store.domain.reward.RewardGroup;
import com.company.store.domain.reward.RewardMission;
import com.company.store.domain.reward.RewardQuest;
import com.company.store.infrastructure.mongo.reward.entity.RewardGroupEntity;

public class RewardDomainMapper {

    public static RewardGroup toRewardGroupDomain(RewardGroupEntity rewardGroupEntity) {
        return new RewardGroup(
                rewardGroupEntity.getId(),
                rewardGroupEntity.getName(),
                rewardGroupEntity.getDescription(),
                rewardGroupEntity.getOrder()
        );
    }

    public static RewardMission toRewardMission(RewardMission rewardMission) {
        return new RewardMission(
                rewardMission.getId(),
                rewardMission.getTitle(),
                rewardMission.getPoint(),
                rewardMission.getOrder()
        );
    }

    public static RewardQuest toRewardQuest(RewardQuest rewardQuest) {
        return new RewardQuest(
                rewardQuest.getId(),
                rewardQuest.getOrder(),
                rewardQuest.getTitle(),
                rewardQuest.getDescription(),
                rewardQuest.getQuestUrl(),
                rewardQuest.getQuestComponent(),
                rewardQuest.getQuestType()
        );
    }
}
