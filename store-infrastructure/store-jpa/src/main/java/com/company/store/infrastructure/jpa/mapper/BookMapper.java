package com.company.store.infrastructure.jpa.mapper;

import com.company.store.domain.book.Book;
import com.company.store.infrastructure.jpa.entity.book.BookJpaEntity;

public class BookMapper {

    public BookMapper() {
        //
    }

    public static BookJpaEntity toJpaEntity(final Book book) {
        return new BookJpaEntity(
                book.getName(),
                book.getAuthor()
        );
    }
}
