package com.sintoburi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.sintoburi.util.UtilRedis;

public class RedisService {

	@Autowired
	private UtilRedis utilRedis;
	
	public void checkCacheData(String key) {
		// 1. key 검색 하고 값이 있으면 값을 반환하고 없으면 null 처리
		
		// 2. null 처리
		switch(key) {
			case "test" :
				break;
		}
	}
	
}
