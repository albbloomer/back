package com.company.store.infrastructure.jpa.entity.book;

import com.company.store.common.exception.ValidateDataException;
import com.company.store.infrastructure.jpa.base.BaseJpaEntity;
import io.micrometer.common.util.StringUtils;
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

    public BookJpaEntity(final Integer id, final String name, final String author) {
        validateBook(id, name, author);
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

    public String getAuthor() {
        return author;
    }

    public void validateBook(final Integer id, final String name, final String author) {
        if (StringUtils.isBlank(name)) {
            throw new ValidateDataException("책 생성에 실패했습니다.");
        }
    }
}