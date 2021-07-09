package com.legacy.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class UtilJWT {
	final String JWT_KEY = "testJWT";
	public static final long ACCESS_TOKEN_VALID_TIME = 6000;
	public static final long REFRESH_TOKEN_VALID_TIME = 6000;
	
	private Key getSigningdKey(String secretKey) {
		byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public Claims getAllClaimsFromToken(String token) throws ExpiredJwtException {
		return Jwts.
				parserBuilder()
				.setSigningKey(getSigningdKey(JWT_KEY))
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	public String getUsernameFromToken(String token) {
		return (String) getAllClaimsFromToken(token).get("username");
	}
	
	public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
	
	private Date getExpirationDateFromToken(String token) {
		return getClaimsFromToken(token, Claims::getExpiration);
	}
	
	public String generateAccessToken(String username) {
		return doGenerateToken(username, ACCESS_TOKEN_VALID_TIME);
	}
	
	public String generateRefreshToken(String username) {
		return doGenerateToken(username, REFRESH_TOKEN_VALID_TIME);
	}
	
	public String doGenerateToken(String username, long validTime) {
		Claims claims = Jwts.claims();
		claims.put("username", username);
		String jwt = Jwts.
				builder()
				.setClaims(claims)
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + validTime))
				.signWith(getSigningdKey(JWT_KEY))
				.compact();
		return jwt;
	}
	
	/*
	public Boolean validateToken(String token, User user) {
		final String username = getUsernameFromToken(token);
		return (username.equals(user.getUsername())) && !isTokenExpired(token);
//	try {
//				
//		final String username = getUsernameFromToken(token);
//
//		return (username.equals(user.getUsername())) && !isTokenExpired(token);
//	} catch (SignatureException e) {
//        logger.info("Invalid JWT signature.");
//        logger.trace("Invalid JWT signature trace: {}", e);
//    } catch (MalformedJwtException e) {
//    	logger.info("Invalid JWT token.");
//    	logger.trace("Invalid JWT token trace: {}", e);
//    } catch (UnsupportedJwtException e) {
//    	logger.info("Unsupported JWT token.");
//    	logger.trace("Unsupported JWT token trace: {}", e);
//    } catch (IllegalArgumentException e) {
//    	logger.info("JWT token compact of handler are invalid.");
//    	logger.trace("JWT token compact of handler are invalid trace: {}", e);
//    }
//	return false;
}
*/
	
	
//	public String getUsernameFromToken(String token) {
//		return (String) getAllClaimsFromToken(token).get("username");
//	}
	
	// 다시 개발하기
	/*
	public String createToken() {
		// header
		Map<String, Object> header = new HashMap<>();
		header.put("typ", "JWT");
		header.put("alg", "HS256");
		
		//payload
		Map<String, Object> payload = new HashMap<>();
		payload.put("data", "I love money");
		
		Long expiredTime = 1000 * 60L * 60L * 2L;
		
		Date expiredDate = new Date();
		expiredDate.setTime(expiredDate.getTime() + expiredTime);

		// Token builder
		String jwt = Jwts.builder()
				.setHeader(header)	// Header
				.setClaims(payload)	// Claims
				.setSubject("test")	// subject
				.setExpiration(expiredDate)
				.signWith(getSigningKey(JWT_KEY)
				.compact();
		
		return jwt;
	}
	
	private Key getSigningKey(String secretKey) {
		byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	public Map<String, Object> verifyToken(String token) throws UnsupportedEncodingException {
		return null;
	}
	*/
}

