package com.company.store.infrastructure.jpa.repository.book;

import com.company.store.domain.book.Book;
import com.company.store.infrastructure.jpa.entity.book.BookJpaEntity;
import com.company.store.infrastructure.jpa.mapper.BookMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class BookRepository {

    /**
     * bookJpaRepository Bean 이 없다고 나오는 오류 <br>
     * 해결 방법 1. bookJpaRepository Interface : @Repository 추가 <br>
     * 해결 방법 2. basePackages <br>
     */
    private final BookJpaRepository bookJpaRepository;

    public BookRepository(BookJpaRepository bookJpaRepository) {
        this.bookJpaRepository = bookJpaRepository;
    }

    public void save(Book book) {
        BookJpaEntity bookJpaEntity = bookJpaRepository.save(BookMapper.toJpaEntity(book));

        return ; //
    }
}
