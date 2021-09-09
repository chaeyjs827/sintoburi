package com.sintoburi.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfiguration {

	private final String redisHost = "localhost";
	private final int redisPort = 6379;
//
//	@Bean
//	public RedisConnectionFactory connectionFactory() {
//		return new LettuceConnectionFactory(redisHost, redisPort);
//	}
//
//	@Bean
//	public RedisTemplate<String, Object> redisTemplate() {
//		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//		redisTemplate.setKeySerializer(new StringRedisSerializer());
//		redisTemplate.setValueSerializer(new StringRedisSerializer());
//		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
//		redisTemplate.setConnectionFactory(connectionFactory());
//		return redisTemplate;
//	}
//	
//	@Bean
//	public StringRedisTemplate strRedisTemplate() {
//		StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
//		stringRedisTemplate.setConnectionFactory(connectionFactory());
//		return stringRedisTemplate;
//	}

}