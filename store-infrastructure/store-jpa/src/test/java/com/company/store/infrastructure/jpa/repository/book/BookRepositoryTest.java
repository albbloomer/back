package com.company.store.infrastructure.jpa.repository.book;

import com.company.store.domain.book.Book;
import com.company.store.infrastructure.jpa.repository.annotation.RepositoryTest;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RepositoryTest
@DisplayName("책 레포지토리는")
@SuppressWarnings({"NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BookRepositoryTest {

    @Autowired BookRepository bookRepository;

    @Nested
    class 가져올때 {

        @Test
        void 정상적으로_가져온다() {

            // expected result
            int exceptedBookListSize = 2;

            // when
            List<Book> booklist = bookRepository.findAll();

            // then
            assertThat(booklist.size()).isEqualTo(exceptedBookListSize);
        }
    }

    @Nested
    class A {

        @BeforeEach
        void setUp() {
            // Todo
        }

        @Test
        void A_detail() {
            // given

            // when

            // then
            assertAll(
                    () -> System.out.println("test_1"),
                    () -> System.out.println("test_2")
            );
        }
    }
}