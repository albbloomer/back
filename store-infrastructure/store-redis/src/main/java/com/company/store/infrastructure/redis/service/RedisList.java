package com.company.store.infrastructure.redis.service;

import io.lettuce.core.api.async.RedisAsyncCommands;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RedisList {

    @Qualifier(value = "redisAsyncCommands")
    private final RedisAsyncCommands<String, Object> redisAsyncCommands;
    @Qualifier(value = "financeRedisTemplate")
    private final RedisTemplate<String, Object> financeRedisTemplate;

    public RedisList(RedisAsyncCommands<String, Object> redisAsyncCommands, RedisTemplate<String, Object> financeRedisTemplate) {
        this.redisAsyncCommands = redisAsyncCommands;
        this.financeRedisTemplate = financeRedisTemplate;
    }

    public void lPush(String k, Object v) {
        ListOperations<String, Object> list = financeRedisTemplate.opsForList();
        list.rightPush(k, v);
    }

    public List<Object> lRange(String k, long l, long l1) {
        ListOperations<String, Object> list = financeRedisTemplate.opsForList();
        return list.range(k, l, l1);
    }

}
