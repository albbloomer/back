package com.company.store.infrastructure.jpa.repository.member;

import com.company.store.domain.member.Member;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
@DisplayName("멤버 레파지토리는")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Nested
    class 저장할때 {

        @Test
        void 저상적으로_저장된다() {
            // given
            final String name = "minyul";
            final Long id = 2423L;
            final Member member = new Member(id, name);

            // when
            final Member savedMember = memberRepository.save(member);

            // then
            assertThat(member.getName()).isEqualTo(savedMember.getName());
            assertThat(member.getId()).isEqualTo(savedMember.getId());
        }
    }
}