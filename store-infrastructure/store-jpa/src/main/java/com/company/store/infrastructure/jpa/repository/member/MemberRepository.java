package com.company.store.infrastructure.jpa.repository.member;

import com.company.store.domain.member.Member;
import com.company.store.infrastructure.jpa.entity.member.MemberJpaEntity;
import com.company.store.infrastructure.jpa.mapper.memberdomainmapper.MemberDomainMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class MemberRepository {

    private final MemberJpaRepository memberJpaRepository;

    public MemberRepository(MemberJpaRepository memberJpaRepository) {
        this.memberJpaRepository = memberJpaRepository;
    }

    public Member save(final Member member) {
        MemberJpaEntity memberJpaEntity = memberJpaRepository.save(MemberDomainMapper.toJpaEntity(member));

        return MemberDomainMapper.toDomain(memberJpaEntity);
    }

    @Transactional(readOnly = true)
    public boolean existsByName(final String name) {
        return memberJpaRepository.existsByName(name);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Member saveRequiredNew(final Member member) {
        MemberJpaEntity memberJpaEntity = memberJpaRepository.save(MemberDomainMapper.toJpaEntity(member));
        return MemberDomainMapper.toDomain(memberJpaEntity);
    }
}
