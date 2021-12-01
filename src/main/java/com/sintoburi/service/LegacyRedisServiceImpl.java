package com.sintoburi.service;

import com.sintoburi.service.impl.LegacyRedisService;
import com.sintoburi.service.impl.StRedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.time.Duration;

/**
 * @author seongnamfc
 * @package com.sintoburi.service
 * @file LegacyRedisServiceImpl
 * @description
 * @date 2021/12/01
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class LegacyRedisServiceImpl implements LegacyRedisService {

    @Qualifier("legacyRedisTemplate")
    private final RedisTemplate redisTemplate;

    @Value("${spring.redis-legacy.prefix}")
    private String prefixKey;

    @Override
    public void save(String cacheName, Object key, Object data) {
        Long expireTime = 60L;
        ValueOperations valueOperations = redisTemplate.opsForValue();

        String redisKey = this.getRedisKey(cacheName, key);
        valueOperations.set(redisKey, data, Duration.ofMinutes(expireTime));
    }

    private String getRedisKey(String cacheName, Object key) {
        return prefixKey.concat("_")
                .concat(cacheName).concat(":")
                .concat(key.toString());
    }
}
