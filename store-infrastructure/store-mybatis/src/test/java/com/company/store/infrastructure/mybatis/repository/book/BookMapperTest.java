package com.company.store.infrastructure.mybatis.repository.book;

import com.company.store.domain.book.Book;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SuppressWarnings({"NonAsciiCharacters"})
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BookMapperTest {

    @Autowired BookMapper bookMapper;

    @BeforeEach
    void setUp() {

    }

    @Nested
    class 가져올때 {

        @Test
        void 정상적으로_가져온다_with_mybatis() {

            // expected result
            String exceptedBookName = "minyul";

            // when
            Book book = bookMapper.findById(1L);

            // then
            assertThat(book.getName()).isEqualTo(exceptedBookName);
        }

        @Test
        void 정상적으로_가져온다_with_jdbc() throws Exception {
            // 데이터베이스 연결 정보
            String url = "jdbc:mysql://127.0.0.1:3310/Store";
            String user = "root";
            String password = "root";

            // expected result
            String expectedBookName = "minyul";

            // 직접 JDBC 사용
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT name FROM book WHERE book_id = 1")) {

                // 결과 처리
                String actualBookName = null;
                if (rs.next()) {
                    actualBookName = rs.getString("name");
                }

                // then
                assertThat(actualBookName).isEqualTo(expectedBookName);
            }
        }
    }

    @AfterEach
    void finish() {
        System.out.println("-");
    }

}