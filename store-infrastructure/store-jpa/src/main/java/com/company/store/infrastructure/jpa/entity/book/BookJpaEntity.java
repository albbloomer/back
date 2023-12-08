package com.company.store.infrastructure.jpa.entity.book;

import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class BookJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "author", length = 30, nullable = false)
    private String author;

    protected BookJpaEntity() {
        //
    }

    public BookJpaEntity(String name) {
        this.name = name;
    }

    public BookJpaEntity(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public BookJpaEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public BookJpaEntity(Integer id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}