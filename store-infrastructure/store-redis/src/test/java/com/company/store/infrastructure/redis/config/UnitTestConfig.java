package com.company.store.infrastructure.redis.config;

import com.company.store.infrastructure.redis.service.RedisService;
import com.company.store.infrastructure.redis.service.base.RedisString;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

@Configuration
public class UnitTestConfig {

    @Primary
    @Bean
    public RedisService redisService() {
        return new RedisService(mock(RedisString.class), new ObjectMapper());
    }
}
