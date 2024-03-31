package com.company.store.reward.facade;

import com.company.store.practiceandrefactoring.service.SessionService;
import com.company.store.reward.service.RewardService;
import org.springframework.stereotype.Component;

@Component
public class RewardFacade {

    private final RewardService rewardService;
    private final SessionService sessionService;

    // Todo : redis 의존


    public RewardFacade(RewardService rewardService, SessionService sessionService) {
        this.rewardService = rewardService;
        this.sessionService = sessionService;
    }

    public void getMyPageRewardInfo() {
        // Todo 1) : redis 에서 기존 Group Mission Quest

        // Todo 2) : 현재 사용자에 대한 진행 상황, 완료된 Group Mission Quest

        // Todo 3) : Result -> 필터해서 보내기
    }
}
