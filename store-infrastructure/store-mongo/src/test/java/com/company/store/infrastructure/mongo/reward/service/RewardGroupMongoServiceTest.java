package com.company.store.infrastructure.mongo.reward.service;

import com.company.store.domain.reward.RewardGroup;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("리워드 그룹 레파지토리는")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RewardGroupMongoServiceTest {

    @Autowired
    private RewardGroupMongoService rewardGroupMongoService;

    @Nested
    class 가져올때 {

        @Test
        void 정상적으로_모든_데이터를_가져온다() {

            /**
             * 테스트 실행 시, 초기 데이터를 넣지않고 임시 테스트를 하는 것이기 때문에
             * 해당 부분은 항상 테스트가 성공하지 않는다.
             *
             * Todo : 추후에 지워야할 테스트
             */

            // when
            List<RewardGroup> rewardGroups = rewardGroupMongoService.getAllRewardGroups();

            // then
            assertThat(rewardGroups.size()).isEqualTo(3);
        }
    }
}