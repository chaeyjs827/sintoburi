package com.sintoburi.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sintoburi.entity.AccessTokenEntity;
import com.sintoburi.entity.RefreshTokenEntity;
import com.sintoburi.repository.AccessTokenRepository;
import com.sintoburi.repository.RefreshTokenRepository;

@Service
public class TempJwtService {

	@Autowired
	private AccessTokenRepository accessTokenRepository;

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;
	
	
	public Long saveAccessToken(String accessToken) {
		Long id = null;
		return id;
	}
	
	public Long saveAccessToken(String accessToken, Integer memberId, Date exp, Boolean isRevoked) {
		AccessTokenEntity entity = AccessTokenEntity.builder()
				.id(accessToken)
				.memberId(memberId)
				.expiredDate(exp)
				.isRevoked(isRevoked)
				.build();
		
		accessTokenRepository.save(entity);
		Long id = null;
		return id;
	}
	
	public Long saveRefreshToken(String refreshToken, Date exp, Boolean isRevoked) {
		RefreshTokenEntity entity = RefreshTokenEntity.builder()
				.refreshTokenId(refreshToken)
				.expiredDate(exp)
				.isRevoked(isRevoked)
				.build();
		refreshTokenRepository.save(entity);
		
		Long id = null;
		
		return id;
	}
}
