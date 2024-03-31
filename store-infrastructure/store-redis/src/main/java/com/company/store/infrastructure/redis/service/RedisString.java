package com.company.store.infrastructure.redis.service;

import io.lettuce.core.api.async.RedisAsyncCommands;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class RedisString {

    @Qualifier(value = "redisAsyncCommands")
    private final RedisAsyncCommands<String, Object> redisAsyncCommands;
    @Qualifier(value = "financeRedisTemplate")
    private final RedisTemplate<String, Object> financeRedisTemplate;

    public RedisString(RedisAsyncCommands<String, Object> redisAsyncCommands, RedisTemplate<String, Object> financeRedisTemplate) {
        this.redisAsyncCommands = redisAsyncCommands;
        this.financeRedisTemplate = financeRedisTemplate;
    }

    public void set(String key, Object value) {
        redisAsyncCommands.set(key, value);
    }

    public Optional<Object> get(String key) {
        try {
            return Optional.ofNullable(financeRedisTemplate.opsForValue().get(key));
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public void set(String key, Object value, Long timeout) {
        financeRedisTemplate.opsForValue()
                .set(key, value, timeout, TimeUnit.MILLISECONDS);
    }

    public void set(String key, Object value, Duration timeout) {
        financeRedisTemplate.opsForValue()
            .set(key, value, timeout);
    }

    public void increment(String key) {
        financeRedisTemplate.opsForValue()
                .increment(key);
    }

    public List<Object> multiGet(List<String> keys) {
        return financeRedisTemplate.opsForValue()
                .multiGet(keys);
    }

}
