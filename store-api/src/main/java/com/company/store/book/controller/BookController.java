package com.company.store.book.controller;

import com.company.store.book.dto.BookRegistrationRequest;
import com.company.store.book.facade.BookFacade;
import com.company.store.book.service.BookService;
import com.company.store.common.ResponseDto;
import com.company.store.domain.book.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/book")
@RestController
@RequiredArgsConstructor
public class BookController {

    private final BookFacade bookFacade;

    @PostMapping
    public ResponseDto<Void> registerBook(
            @RequestBody final BookRegistrationRequest bookRegistrationRequest) {
        bookFacade.registerBook(bookRegistrationRequest);
        return ResponseDto.ok();
    }

    @GetMapping("/test")
    public ResponseDto<Book> getBook() {
        return ResponseDto.ok(bookFacade.getBook(1L));
    }
}
