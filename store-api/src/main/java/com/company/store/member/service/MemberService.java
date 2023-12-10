package com.company.store.member.service;


import com.company.store.common.exception.BusinessException;
import com.company.store.domain.member.Member;
import com.company.store.infrastructure.jpa.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public Member signupMember(final Member member) {
        // 저장 및 존재 여부 확인 비지니스 로직에 대한 역할을 Repository
        boolean exists = memberRepository.existsByName(member.getName());
        if (exists) {
            throw new BusinessException("존재하는 회원입니다.");
        }
        return memberRepository.save(member);
    }
}
