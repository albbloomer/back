package com.company.store.member.service;

import com.company.store.common.exception.BusinessException;
import com.company.store.domain.member.Member;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@DisplayName("멤버 서비스는")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Nested
    class 회원가입_시 {

        @Test
        void 회원을_생성한다() {
            // given
            final String name = "minyul";
            final Long id = 243L;

            Member member = new Member(id, name);

            // when
            Member savedMember = memberService.signupMember(member);

            // then
            assertThat(member.getId()).isEqualTo(savedMember.getId());
            assertThat(member.getName()).isEqualTo(savedMember.getName());
        }

        // 미리 생성되야 하므로 data.sql 에 스크립트 작성 및 application.yml 에 옵션
        @Test
        void 이미_존재하는_이름이_있을시_예외가_발생한다() {
            // given
            final String name = "savedminyul";
            final Long id = 244L;

            Member member = new Member(id, name);

            assertThatThrownBy(() -> memberService.signupMember(member))
                    .isInstanceOf(BusinessException.class)
                    .hasMessage("존재하는 회원입니다.");
        }

    }
}