package com.company.store.book.facade;

import com.company.store.book.dto.BookRegistrationRequest;
import com.company.store.book.service.BookService;
import com.company.store.domain.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BookFacade {

    private final BookService bookService;

    public void registerBook(final BookRegistrationRequest bookRegistrationRequest) {
        bookService.registerBook(bookRegistrationRequest.toDomain());
    }

    public Book getBook(long id) {
        return bookService.getBook(id);
    }
}
