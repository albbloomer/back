package com.company.store.infrastructure.redis.service;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
public class RedisStringTest {

    @Autowired
    private RedisString redisString;

    @Test
    public void testGet() {
        String key = "testKey";
        String value = "testValue";

        redisString.set(key, value);
        assertEquals(value, redisString.get(key).orElse(null));
    }
}