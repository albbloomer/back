package com.company.store.infrastructure.jpa.repository;

import com.company.store.domain.book.Book;
import com.company.store.infrastructure.jpa.repository.annotation.RepositoryTest;
import com.company.store.infrastructure.jpa.repository.book.BookRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RepositoryTest
@DisplayName("data.sql 파일은")
@SuppressWarnings({"NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SqlTest {

    @Autowired BookRepository bookRepository;

    @Test
    void 정상적으로_데이터를_넣어준다() {

        // given : data.sql init 역할

        // when
        List<Book> bookList = bookRepository.findAll();

        // then
        assertThat(bookList.size()).isEqualTo(2);
    }
}
