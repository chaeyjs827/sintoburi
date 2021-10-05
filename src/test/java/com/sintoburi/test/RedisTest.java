package com.sintoburi.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate<String, String> redisTemplateGeneric;
    
    @Test
    void testStrings() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String key = "stringKey";

        valueOperations.set(key, "hello");

        String value = valueOperations.get(key);

		System.out.println("value : " + value);
//        assertThat(value).isEqualTo("hello");
    }

    
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
