package com.company.store.infrastructure.redis.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class RedisBase {

    @Qualifier(value = "financeRedisTemplate")
    private final RedisTemplate<String, Object> financeRedisTemplate;

    public RedisBase(RedisTemplate<String, Object> financeRedisTemplate) {
        this.financeRedisTemplate = financeRedisTemplate;
    }

    public void delete(String key) {
        financeRedisTemplate.delete(key);
    }

    public void delete(Collection<String> keys) {
        financeRedisTemplate.delete(keys);
    }

    public byte[] dump(String key) {
        return financeRedisTemplate.dump(key);
    }

    public Boolean hashKey(String key) {
        return financeRedisTemplate.hasKey(key);
    }

    public Boolean expire(String key, Long timeout, TimeUnit unit) {
        return financeRedisTemplate.expire(key, timeout, unit);
    }

    public Boolean expireAt(String key, Date date) {
        return financeRedisTemplate.expireAt(key, date);
    }

    public Set<String> keys(String pattern) {
        return financeRedisTemplate.keys(pattern);
    }

    public Boolean move(String key, Integer dbIndex) {
        return financeRedisTemplate.move(key, dbIndex);
    }

    public Boolean persist(String key) {
        return financeRedisTemplate.persist(key);
    }

    public Long getExpire(String key, TimeUnit unit) {
        return financeRedisTemplate.getExpire(key, unit);
    }

    public Long getExpire(String key) {
        return financeRedisTemplate.getExpire(key);
    }

    public String randomKey() {
        return financeRedisTemplate.randomKey();
    }

    public void rename(String oldKey, String newKey) {
        financeRedisTemplate.rename(oldKey, newKey);
    }

    public Boolean renameIfAbsent(String oldKey, String newKey) {
        return financeRedisTemplate.renameIfAbsent(oldKey, newKey);
    }

    public DataType type(String key) {
        return financeRedisTemplate.type(key);
    }

    public Cursor<byte[]> scan(String pattern, Long count) {
        return Objects.requireNonNull(
                financeRedisTemplate.getConnectionFactory())
        .getConnection()
        .scan(ScanOptions.scanOptions().match(pattern).count(count)
                .build());
    }

}
