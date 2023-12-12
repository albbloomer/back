package com.company.store.member.dto;

import com.company.store.domain.member.Member;

public record MemberSignupRequest (
        String name
) {

    public Member toDomain(final Long id) {
        return new Member(id, name);
    }
}
