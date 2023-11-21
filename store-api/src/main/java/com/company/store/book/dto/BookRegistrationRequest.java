package com.company.store.book.dto;

import com.company.store.domain.book.Book;

public record BookRegistrationRequest(
        String title,
        String author
) {

    public Book toDomain() {
        return new Book(title, author);
    }
}
