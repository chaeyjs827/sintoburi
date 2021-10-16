package com.sintoburi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sintoburi.entity.RefreshTokenEntity;
import com.sintoburi.repository.AccessTokenRepository;
import com.sintoburi.repository.RefreshTokenRepository;

@Service
public class JwtService {

	@Autowired
	private AccessTokenRepository accessTokenRepository;

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	
	public Long saveAccessToken(String accessToken) {
		Long id = null;
		return id;
	}
	
	public Long saveRefreshToken(String refreshToken) {
		RefreshTokenEntity entity = RefreshTokenEntity.builder()
				.refreshTokenId(refreshToken)
				.build();
		
		refreshTokenRepository.save(null);
		
		
		Long id = null;
		
		return id;
	}
}
