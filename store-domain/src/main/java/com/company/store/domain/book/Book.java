package com.company.store.domain.book;

import java.time.LocalDateTime;

public class Book {

    private Long id;
    private String name;
    private String author;
    private LocalDateTime createTime;

    public Book(String name, String author) {
        this.name = name;
        this.author = author;
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
