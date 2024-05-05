package com.company.store.infrastructure.jpa.repository.config;

import com.company.store.infrastructure.jpa.repository.book.BookJpaRepository;
import com.company.store.infrastructure.jpa.repository.book.BookRepository;
import com.company.store.infrastructure.jpa.repository.member.MemberJpaRepository;
import com.company.store.infrastructure.jpa.repository.member.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryTestConfiguration {

    /**
     * 우선, BookRepository Impl 이 있어야하고
     * JpaRepository 와 인터페이스가 있어야함. 우선 잘못된 설계이긴 함
     */

    @Bean
    public BookRepository bookRepository(final BookJpaRepository bookJpaRepository) {
        return new BookRepository(bookJpaRepository);
    }

    @Bean
    public MemberRepository memberRepository(final MemberJpaRepository memberJpaRepository) {
        return new MemberRepository(memberJpaRepository);
    }

}
