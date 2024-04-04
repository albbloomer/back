package com.company.store.infrastructure.redis.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.embedded.RedisServer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RedisStringTest {

    private static RedisServer redisServer;

    @Autowired
    private RedisString redisString;

    @BeforeEach
    public void setUp() {
        redisServer = new RedisServer(6379);
        redisServer.start();
    }

    @AfterEach
    public void tearDown() {
        redisServer.stop();
    }

    @Test
    public void testGet() {
        String key = "testKey";
        String value = "testValue";

        redisString.set(key, value);
        assertEquals(value, redisString.get(key).orElse(null));
    }
}