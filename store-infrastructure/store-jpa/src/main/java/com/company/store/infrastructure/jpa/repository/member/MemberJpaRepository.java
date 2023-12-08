package com.company.store.infrastructure.jpa.repository.member;

import com.company.store.infrastructure.jpa.entity.member.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity, Long> {
    //
}
