package com.company.store.infrastructure.mybatis.repository.book;

import com.company.store.domain.book.Book;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SuppressWarnings({"NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BookMapperTest {

    @Autowired BookMapper bookMapper;

    @Nested
    class 가져올때 {

        @Test
        void 정상적으로_가져온다() {

            // expected result
            String exceptedBookName = "abc";

            // when
            Book book = bookMapper.findById(1L);

            // then
            assertThat(book.getName()).isEqualTo(exceptedBookName);
        }
    }

}