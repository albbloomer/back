package com.company.store.infrastructure.redis.dto;

import com.company.store.domain.book.Book;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookRedisResponse {

    private Long id;
    private String name;
    private String author;
    private LocalDateTime createTime;

    public BookRedisResponse() {

    }

    public BookRedisResponse(Long id, String name, String author, LocalDateTime createTime) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.createTime = createTime;
    }

    public Book toDomain() {

        return new Book(
                this.name,
                this.author
        );
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }
}
