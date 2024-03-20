package com.company.store.practiceandrefactoring.service;

import com.company.store.domain.book.Book;
import com.company.store.domain.member.Member;
import com.company.store.infrastructure.jpa.repository.book.BookRepository;
import com.company.store.infrastructure.jpa.repository.member.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransactionalPropagationService {

    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    public TransactionalPropagationService(
            MemberRepository memberRepository,
            BookRepository bookRepository) {
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void requiredNewTest() {
        bookRepository.save(new Book("book_1", "name_1"));
        memberRepository.saveRequiredNew(new Member(1L));
    }
}
