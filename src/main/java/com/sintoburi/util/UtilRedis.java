package com.sintoburi.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class UtilRedis {

	@Autowired
	private StringRedisTemplate redisTemplate;	

	public void setToken(String key, String value) {
		
		final ValueOperations<String, String> vop = redisTemplate.opsForValue();
		
		vop.set(key, value);
	}
	
	public String getToken(String key) {
		
		final ValueOperations<String, String> vop = redisTemplate.opsForValue();
		
		return vop.get(key);
	}
	
}
