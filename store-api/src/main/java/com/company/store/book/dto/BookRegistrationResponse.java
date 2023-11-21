package com.company.store.book.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record BookRegistrationResponse(
        Long id,
        String title,
        String author,

        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime createTime
) {

    // Todo : from
}
