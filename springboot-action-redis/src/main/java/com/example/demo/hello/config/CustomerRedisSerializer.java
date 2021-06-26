package com.example.demo.hello.config;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

/**
 * 自定义 redis 序列化器
 */
@Component
public class CustomerRedisSerializer implements RedisSerializer {
    @Override
    public byte[] serialize(Object o) throws SerializationException {
        return o.toString().getBytes(StandardCharsets.UTF_8);
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
