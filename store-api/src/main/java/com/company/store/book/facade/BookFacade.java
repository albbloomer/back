package com.company.store.book.facade;

import com.company.store.book.dto.BookRegistrationRequest;
import com.company.store.book.service.BookService;
import com.company.store.domain.book.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class BookFacade {

    private final BookService bookService;

    public void registerBook(final BookRegistrationRequest bookRegistrationRequest) {
        bookService.registerBook(bookRegistrationRequest.toDomain());
    }

    public Book getBook(long id) {
        log.info("테스트 중");
        return bookService.getBook(id);
    }
}
