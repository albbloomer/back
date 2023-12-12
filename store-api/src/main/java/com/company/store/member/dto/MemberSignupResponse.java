package com.company.store.member.dto;

import com.company.store.domain.member.Member;

public record MemberSignupResponse (
        Long id,
        String name
) {

    public static MemberSignupResponse from(final Member member) {
        return new MemberSignupResponse(
                member.getId(),
                member.getName()
        );
    }
}
