package com.company.store.infrastructure.redis.service;

import com.company.store.domain.book.Book;
import com.company.store.infrastructure.redis.dto.BookRedisResponse;
import com.company.store.infrastructure.redis.service.base.RedisString;
import com.esotericsoftware.kryo.util.ObjectMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SuppressWarnings({"NonAsciiCharacters"})
@ActiveProfiles("test")
@DisplayName("레디스 서비스는")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RedisServiceTest {

    @InjectMocks RedisService redisService;
    @Mock RedisString redisString;
    ObjectMapper objectMapper;

    @BeforeEach
    void init() {
        this.objectMapper = new ObjectMapper();
    }

    @Nested
    class 가져올때 {

        @DisplayName("Redis Cache 에서 Book Key 를 이용해 데이터를 반환한다.")
        @Test
        void get_book_response() {
            // given
            String bookKey = "store:book"; // 임시
            Book expectedBook = new Book("name_1", "author_1");

            // when
            given(objectMapper.convertValue(redisString.get(bookKey), BookRedisResponse.class))
                    .willReturn(new BookRedisResponse(1L, "name_1","author_1", LocalDateTime.now()));
            Book bookResponse = redisService.getBookResponse(bookKey);

            // then
            assertThat(bookResponse.getName()).isEqualTo(expectedBook.getName());
            assertThat(bookResponse.getAuthor()).isEqualTo(expectedBook.getAuthor());

        }
    }
}