package com.company.store.infrastructure.redis.service;

import io.lettuce.core.KeyScanCursor;
import io.lettuce.core.RedisFuture;
import io.lettuce.core.ScanArgs;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.async.RedisAsyncCommands;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class RedisHash {

    @Qualifier(value = "redisAsyncCommands")
    private final RedisAsyncCommands<String, Object> redisAsyncCommands;
    @Qualifier(value = "redisTemplate")
    private final RedisTemplate<String, Object> redisTemplate;

    public RedisHash(RedisAsyncCommands<String, Object> redisAsyncCommands, RedisTemplate<String, Object> redisTemplate) {
        this.redisAsyncCommands = redisAsyncCommands;
        this.redisTemplate = redisTemplate;
    }

    public void put(String key, Map<String, Object> hashKeyToValue) {
        StatefulRedisConnection connection = redisAsyncCommands.getStatefulConnection();
        RedisAsyncCommands async = connection.async();
        async.setAutoFlushCommands(false);
        async.hmset(key, hashKeyToValue);
        async.flushCommands();
    }

    public RedisFuture<KeyScanCursor<String>> scanAsync(String key, String query) {
        return redisAsyncCommands.scan(
                ScanArgs
                        .Builder
                        .limit(100)
                        .match(key + "*:*"+ query + "*")
        );
    }

    public Cursor<Map.Entry<Object, Object>> scan(String key, ScanOptions options) {
        return redisTemplate.opsForHash()
                .scan(key,options);
    }
}
