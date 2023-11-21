package com.company.store.book.controller;

import com.company.store.book.dto.BookRegistrationRequest;
import com.company.store.book.facade.BookFacade;
import com.company.store.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
