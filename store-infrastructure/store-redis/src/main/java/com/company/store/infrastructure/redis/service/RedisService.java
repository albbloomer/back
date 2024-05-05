package com.company.store.infrastructure.redis.service;

import com.company.store.domain.book.Book;
import com.company.store.infrastructure.redis.dto.BookRedisResponse;
import com.company.store.infrastructure.redis.service.base.RedisString;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class RedisService {

    private final RedisString redisString;
    private final ObjectMapper objectMapper;

    public RedisService(
            RedisString redisString,
            ObjectMapper objectMapper) {
        this.redisString = redisString;
        this.objectMapper = objectMapper;
    }

    public Book getBookResponse(String key) {
        BookRedisResponse bookRedisResponse = objectMapper.convertValue(redisString.get(key), BookRedisResponse.class);
        // Todo : business Logic ex 분기 처리

        return bookRedisResponse.toDomain();
    }
}
