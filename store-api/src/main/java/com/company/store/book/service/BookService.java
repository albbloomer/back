package com.company.store.book.service;

import com.company.store.domain.book.Book;
import com.company.store.infrastructure.jpa.repository.book.BookRepository;
import com.company.store.infrastructure.mybatis.repository.book.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public void registerBook(final Book book) {
        bookRepository.save(book);
    }

    public String test(final Book book) {
        bookRepository.save(book);
        return "ok";
    }

    public Book getBook(final long bookId) {
        Book book = bookMapper.findById(bookId);
        return book;
    }
}
