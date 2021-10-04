package com.sintoburi.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class RedisTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private StringRedisTemplate redisTemplate;
	
	@Test
	@Cacheable(cacheNames = "test", value = "healthy", key ="#mask")
	public void testString() throws Exception {
	
		final String key = "testJun";
		
		final ValueOperations<String, String> str = redisTemplate.opsForValue();
		
		str.set(key, "1");
		final String result = str.get(key);
		System.out.println("result : " + result);
	}
}
