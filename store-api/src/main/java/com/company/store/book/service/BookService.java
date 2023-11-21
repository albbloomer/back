package com.company.store.book.service;

import com.company.store.domain.book.Book;
import com.company.store.infrastructure.jpa.repository.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    public void RegisterBook(final Book book) {
        bookRepository.save(book);
    }
}
