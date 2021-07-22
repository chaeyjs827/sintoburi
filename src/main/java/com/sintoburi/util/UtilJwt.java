package com.sintoburi.util;

import java.security.Key;
import java.util.Date;
import java.util.Map;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/*
 * Jwt 토큰의 라이프 사이클
 * Jwt, Access-Token, Refresh-Token 모두 만료 시간이 필요하다.
 * 토큰의 구조는 아래와 같이 구현할것
 * - Jwt
 *  	- at(access-token)
 *  	- rt(refresh-token)
 *  	- username
 *  	- ct(created-time)
 *  	- iat(issued-at-time)
 *  	- exp(expired)
 * 
 * 1. 로그인	-> Access-Token
 * 			-> Refresh-Token(DB에 저장)
 * 			두개 모두 쿠키게 저장됨
 * 
 * 2. API 요청을 하면 토큰의 유효성 검사를 하는 미들웨어가 필요함
 * 		case1 : access-token(만료), refresh-token(만료) => 에러->로그인 다시해야함
 * 		case2 : access-token(유효), refresh-token(만료) => refresh-token 재발급
 * 		case3 :	access-token(만료), refresh-token(유효) => access-token 재발급
 * 		case4 : access-token(만료), refresh-token(만료) => 다음 로직 실행
 * 
 * 3. 로그아웃 하면 access-token과 refresh-token 모두 만료
 * 
 * 4. 발급된 토큰을 request-header에 담아 API 요청을 하면 됨;
 */

@Component
public class UtilJwt {

	private static final String SECRET_KEY = "test_secret_key_greater_than_256_should_this_be_bigger";
	
	public String createToken(String tokenName, long expTime) {
		if(expTime <= 0) {
			throw new RuntimeException("Expired time must be greater than 0");
		}
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;	// 토큰 암호화 알고리즘
		
		byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);	// Binary Data를 Text로 바꿈
		Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());	// 암호화된 key
		
		return Jwts.builder()
				.setHeaderParam("type", "jwt")
				.setSubject(tokenName)
				.signWith(signingKey, signatureAlgorithm)
				.setExpiration(new Date(System.currentTimeMillis()+expTime))
				.compact();
	}
	
	public String authenticateByToken(String token) {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
	
	public Claims getClaimsByToken(String token) {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims;
	}
	
}
