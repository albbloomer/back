package com.company.store.infrastructure.jpa.entity.book;

import com.company.store.infrastructure.jpa.base.BaseJpaEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "book")
public class BookJpaEntity extends BaseJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
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