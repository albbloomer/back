package com.company.store.infrastructure.jpa.mapper.memberdomainmapper;

import com.company.store.domain.member.Member;
import com.company.store.infrastructure.jpa.entity.member.MemberJpaEntity;

public class MemberDomainMapper {

    public static MemberJpaEntity toJpaEntity(final Member member) {

        return new MemberJpaEntity(
                member.getId(),
                member.getName()
        );
    }

    public static Member toDomain(final MemberJpaEntity memberJpaEntity) {
        return new Member(
                memberJpaEntity.getId(),
                memberJpaEntity.getName()
        );
    }
}
