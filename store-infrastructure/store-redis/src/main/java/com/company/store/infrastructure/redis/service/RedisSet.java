package com.company.store.infrastructure.redis.service;

import io.lettuce.core.api.async.RedisAsyncCommands;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Set;

import static java.util.Collections.emptySet;

@Service
public class RedisSet {

    @Qualifier(value = "redisAsyncCommands")
    private final RedisAsyncCommands<String, Object> redisAsyncCommands;
    @Qualifier(value = "financeRedisTemplate")
    private final RedisTemplate<String, Object> financeRedisTemplate;

    public RedisSet(RedisAsyncCommands<String, Object> redisAsyncCommands, RedisTemplate<String, Object> financeRedisTemplate) {
        this.redisAsyncCommands = redisAsyncCommands;
        this.financeRedisTemplate = financeRedisTemplate;
    }

    public Long add(String key, Object ...values) {
        return financeRedisTemplate.opsForSet().add(key, values);
    }

    public Long remove(String key, Object ...values) {
        return financeRedisTemplate.opsForSet().remove(key, values);
    }

    public Object pop(String key) {
        return financeRedisTemplate.opsForSet().pop(key);
    }

    public Boolean move(String key, String value, String destKey) {
        return financeRedisTemplate.opsForSet().move(key, value, destKey);
    }

    public Long size(String key) {
        return financeRedisTemplate.opsForSet().size(key);
    }

    public Set<Object> intersect(String key, String otherKey) {
        return financeRedisTemplate.opsForSet().intersect(key, otherKey);
    }

    public Set<Object> members(String key) {
        return (StringUtils.hasText(key)) ?
            financeRedisTemplate.opsForSet().members(key)
                : emptySet();
    }

}
