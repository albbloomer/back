package com.company.store.member.facade;

import com.company.store.domain.member.Member;
import com.company.store.member.dto.MemberSignupRequest;
import com.company.store.member.dto.MemberSignupResponse;
import com.company.store.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@RequiredArgsConstructor
@Component
public class MemberFacade {

    private final MemberService memberService;

    public MemberSignupResponse signupMember(final MemberSignupRequest memberSignupRequest) {
        // Todo : 외부 ( 예를 들어, 특정 값 생성 ) -> 임시로 Random Util
        long memberSpecialId = new Random().nextLong();
        Member member = memberService.signupMember(memberSignupRequest.toDomain(memberSpecialId));

        return MemberSignupResponse.from(member);
    }
}
