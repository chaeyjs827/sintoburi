package com.sintoburi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;


@Configuration
public class RedisConfiguration {
	
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(host, port);
    }
    
    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<?, ?> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }
    
//	RedisConnectionFactory connectionFactory;
//	
//	@Bean 
//	public CacheManager redisCacheManager() {
//		RedisCacheConfiguration redisCacheConfiguration = 
//				RedisCacheConfiguration.defaultCacheConfig()
//				.serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
//				.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
//		
//		return RedisCacheManager.RedisCacheManagerBuilder
//				.fromConnectionFactory(connectionFactory)
//				.cacheDefaults(redisCacheConfiguration)
//				.build();
//	}
	
	// 스프링 로컬 캐시 사용
//	private final String redisHost = "localhost";
//	private final int redisPort = 6379;
//
//	@Bean
//	public RedisConnectionFactory redisConnectionFactory() {
//		return new LettuceConnectionFactory(redisHost, redisPort);
//	}
//	
//	@Bean
//	public RedisTemplate<?, ?> redisTemplate() {
//		RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setConnectionFactory(redisConnectionFactory());
//		return redisTemplate;
//	}
	
}