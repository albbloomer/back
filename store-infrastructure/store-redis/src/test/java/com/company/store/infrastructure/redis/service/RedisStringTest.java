package com.company.store.infrastructure.redis.service;

import com.company.store.infrastructure.redis.EmbeddedRedisTestConfig;
import com.company.store.infrastructure.redis.config.RedisConfig;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {
        EmbeddedRedisTestConfig.class,
        RedisConfig.class,
        RedisString.class
})
@ActiveProfiles("test")
@SpringBootTest
public class RedisStringTest {

    @Autowired
    private RedisString redisString;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testApplicationContext() {
        assertNotNull(applicationContext);
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }

    @Test
    public void testGet() {
        String key = "testKey";
        String value = "testValue";

        redisString.set(key, value);
        assertEquals(value, redisString.get(key).orElse(null));
    }
}