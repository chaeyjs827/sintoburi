package com.sintoburi.util;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.sintoburi.dto.auth.JwtDto;
import com.sintoburi.dto.auth.JwtHeaderDto;
import com.sintoburi.dto.auth.JwtPayloadDto;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.sintoburi.config.JwtConfig;
import com.sintoburi.service.TempJwtService;
import com.sitoburi.constant.JwtConst;
import org.springframework.web.client.RestTemplate;

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
@Slf4j
public class JwtAuth extends JwtConfig {

	// 30( 1000 * 60초 * 30분) = 30분
	private long ACCESS_TOKEN_EXP = 1000 * 60l * 30l;
	// 30일( 1000 * 60초 * 60초 * 24시간 * 30일) = 30일
	private long REFRESH_TOKEN_EXP = 1000 * 60l * 60l * 24l * 30;

	//    public static String jerrySecretKey = "zkUIXWt2yv3QzK3elxJh8dsAiWjGqKmV";
	public static String jerrySecretKey = "jerrygaoyanglaraveljwtlaraveljwt";
	public static String tempSecretKey = "bdQULuaX6xST06O66QelgfWH5gatw4IQBAFZM0YN";

	// last check
	public static String last_tempSecretKey = "bdQULuaX6xST06O66QelgfWH5gatw4IQBAFZM0YN";

	@Autowired
	private UtilRedis utilRedis;

	@Autowired
	private TempJwtService jwtService;

	private static final String SECRET_KEY = "test_secret_key_greater_than_256_should_this_be_bigger_fuck";

	@Transactional
	public String createJwtToken(String username) {

		String at = createToken(JwtConst.ACCESS_TOKEN.getShortName(), ACCESS_TOKEN_EXP);	// access-token
		String rt = createToken(JwtConst.REFRESH_TOKEN.getShortName(), REFRESH_TOKEN_EXP);	// refresh-token

		log.debug("create jwt token");

		/*
		 	{
			  "typ": "JWT",
			  # "alg": "RS256"
			}

		  {
			  "at": "at",
			  "rt": "rt",
			  "id": "s_customer",
			  # "isExpired": false,
			  # "created_at": "20210928103512",
			  # "iat": 1632792912,
			  # "exp": 1635384912
}
		 */

		long now = System.currentTimeMillis();
		Date issuedAt = new Date();

		// jwt의 redis 메카니즘은 확인 후 업데이트 해야함. 지금은 redis 연동 테스트 목적으로 개발됨
//		utilRedis.setToken(tokenName, jwt);
		String jwt = Jwts.builder()
				.setHeaderParam("type", "jwt")
				.claim("username", username)
				.claim(JwtConst.ACCESS_TOKEN.getShortName(), at)
				.claim(JwtConst.ACCESS_TOKEN.getShortName(), rt)
				.setIssuedAt(issuedAt)	// 토큰 발행 시간
				.setNotBefore(issuedAt)	// 지정된 시간 이전에는 토큰을 처리하지 않아야 함을 의미
				.setExpiration(new Date(now+(ACCESS_TOKEN_EXP)))		// 토큰 만료시간
				.compact();

		utilRedis.setToken(username, jwt);
		return jwt;
	}

	private Map<String, Object> getRSAKeys() throws Exception {
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(2048);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		PrivateKey privateKey = keyPair.getPrivate();
		PublicKey publicKey = keyPair.getPublic();
		Map<String, Object> keys = new HashMap<String, Object>();
		keys.put("private", privateKey);
		keys.put("public", publicKey);
		return keys;
	}

	private String createToken(String tokenName, long expTime) {
		if(expTime <= 0) {
			throw new RuntimeException("Expired time must be greater than 0");
		}
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;	// 토큰 암호화 알고리즘

		byte[] secretKeyBytes = DatatypeConverter.parseBase64Binary(SECRET_KEY);	// Binary Data를 Text로 바꿈
		Key signingKey = new SecretKeySpec(secretKeyBytes, signatureAlgorithm.getJcaName());	// 암호화된 key

		long now = System.currentTimeMillis();
		Date issuedAt = new Date(now);
		Date exp = new Date(now+expTime);

 		/**
			{
			   "typ": "JWT",
			   "alg": "RS256"
			}

			{
			  # "aud": "2",
			  "jti": "483f2c50032f5b9e6f7888a462fab8ba386285631c3365fca3d8f22fcf2203d30d480af819a08265",
			  "iat": 1632792911,
			  "nbf": 1632792911,
			  "exp": 1664328911,
			  # "sub": "1",
			  # "scopes": []
			}
		 */

		String jwt = Jwts.builder()
				.setHeaderParam("type", tokenName)
				.setId(UUID.randomUUID().toString())	// jti
				.setIssuedAt(issuedAt)	// 토큰 발행 시간
				.setNotBefore(issuedAt)	// 지정된 시간 이전에는 토큰을 처리하지 않아야 함을 의미
				.signWith(signingKey, signatureAlgorithm)	// 토큰 암호화 알고리즘
				.setExpiration((exp))		// 토큰 만료시간
//				.setAudience("");	// audience는 토큰을 사용할 수신자인데.. 정확히 어떻게 사용 하는지 파악 필
//				.setSubject(tokenName)	// 뭔지 아직 파악 안됨
				.compact();


//		if(tokenName.equals(JwtConst.ACCESS_TOKEN.getShortName())) {
//			jwtService.saveAccessToken(jwt, 999, exp, false);
//		} else if(tokenName.equals(JwtConst.REFRESH_TOKEN.getShortName())) {
//			jwtService.saveRefreshToken(jwt, exp, false);	// isRevoked 사용 하기 전까지는 false로 저장
//		}
		return jwt;
	}


//	public String testToken(JwtDto jwtDto) {
//		return hmacSha256(null, jwtDto.getPayload());
//	}

	private String hmacSha256(String data, String secret) {
		try {
			byte[] hash = secret.getBytes(StandardCharsets.UTF_8);
			Mac sha256Hmac = Mac.getInstance("HmacSHA256");
			SecretKeySpec secretKey = new SecretKeySpec(hash, "HmacSHA256");
			sha256Hmac.init(secretKey);

			byte[] signedBytes = sha256Hmac.doFinal(data.getBytes(StandardCharsets.UTF_8));

			return encodeStringToBase64(signedBytes);
		} catch (NoSuchAlgorithmException | InvalidKeyException ex) {
			return null;
		}
	}

	private String encodeStringToBase64(byte[] bytes) {
		return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
	}

//	signature = hmacSha256(encodedHeader + "." + encode(payload));


	public Boolean authenticateByToken(String token) {
		Claims claims = null;
		Boolean result = false;

//		String SECRET_KEY = "test_secret_key_greater_than_256_should_this_be_bigger_fuck";
		String jerrySecretKey = "jerrygaoyanglaraveljwtlaraveljwt";
		String tempSecretKey = "bdQULuaX6xST06O66QelgfWH5gatw4IQBAFZM0YN";

		// last check
		String last_tempSecretKey = "bdQULuaX6xST06O66QelgfWH5gatw4IQBAFZM0YN";

		log.info("[generated keys]");
		Map<String, Object> rsaKeys = null;
		try {
			rsaKeys = getRSAKeys();
		} catch(Exception e) {
			e.printStackTrace();
		}

		PublicKey publicKey = (PublicKey) rsaKeys.get("public");
		PrivateKey privateKey = (PrivateKey) rsaKeys.get("private");
		log.info("[generated keys]");

		try {
			claims = Jwts.parserBuilder()
					.setSigningKey(DatatypeConverter.parseBase64Binary(jerrySecretKey))
//					.setSigningKey(privateKey)
					.build()
					.parseClaimsJws(token)
					.getBody();

		} catch (IllegalArgumentException ex){
			log.error("[에러 발생] Unable to get JWT token : JWT claims이 비어있음!!");
			log.error(ex.getMessage());
			ex.printStackTrace();
		} catch (ExpiredJwtException ex){
			log.error("[에러 발생] : ExpiredJwtException : JWT 유효기간이 초과됨!!");
			log.error(ex.getMessage());
			ex.printStackTrace();
		} catch (UnsupportedJwtException ex) {
			log.error("[에러 발생] UnsupportedJwtException : 예상하는 형식과 일치하지 않는 특정 형식의 JWT!!");
			log.error(ex.getMessage());
			ex.printStackTrace();
		} catch (MalformedJwtException ex) {
			log.error("[에러 발생] MalformedJwtException : JWT가 올바르게 구성되지 않았음!!");
			log.error(ex.getMessage());
			ex.printStackTrace();
		} catch (SignatureException ex) {
			log.error("[에러 발생] SignatureException : JWT 기존 서명의 Signature가 확인되지 않음!!");
			log.error(ex.getMessage());
			ex.printStackTrace();
		}

		return result;
	}

	public Claims getClaimsByToken(String token) {
//		Claims claims = Jwts.parserBuilder()
//				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
//				.build()
//				.
		return null;
	}

	public void testAuthenticateByToken(String token) {

		/*
		String testPassword = "test비밀번호";
		String fakePassword = "tes비밀번호";
		String fakePassword2 = "test비밀번호1";
		String fakePassword3 = "ttest비밀번호";
		String fakePassword4 = "est비밀번호";

		String encrypted = BCrypt.hashpw(testPassword, BCrypt.gensalt());

		log.info("encrypted : " + encrypted);

		log.info("testPassword와 encrypted 비교 : " + BCrypt.checkpw(testPassword, encrypted));
		log.info("testPassword와 encrypted 비교 : " + BCrypt.checkpw(fakePassword, encrypted));
		log.info("testPassword와 encrypted 비교 : " + BCrypt.checkpw(fakePassword2, encrypted));
		log.info("testPassword와 encrypted 비교 : " + BCrypt.checkpw(fakePassword3, encrypted));
		log.info("testPassword와 encrypted 비교 : " + BCrypt.checkpw(fakePassword4, encrypted));
		*/


		log.info("testAuthenticateByToken 실행");
//		String jerrySecretKey = "jerrygaoyanglaraveljwtlaraveljwt";
		String jerrySecretKey = "jerrygaoyanglaraveljwtlaraveljwt이게 되면 안된다니까ㅠㅠㅠ";
//		String secretKey = "zkUIXWt2yv3QzK3elxJh8dsAiWjGqKmV";
		String secretKey = "이고ㅓ 되면 바로 운동 간다";
		String tempSecretyKey = "secret-key";

		String[] jwtArray = getJwtArray(token);
		String headerBase64 = jwtArray[0];
		String payloadBase64 = jwtArray[1];
		String signatureBase64 = jwtArray[2];

		log.info("headerBase64 : " + headerBase64);
		log.info("payloadBase64 : " + payloadBase64);
		log.info("signatureBase64 : " + signatureBase64);

		String secretKeyBase64 = encodeBase64(jerrySecretKey);
		log.info("secret-key : " + jerrySecretKey);
		log.info("secretKeyBase64 : " + secretKeyBase64);

		String verifyString = headerBase64+"."+payloadBase64+"."+secretKeyBase64;

		String payloadDecoded = decodeBase64(payloadBase64);
		log.info("payloadDecoded = " + payloadDecoded);

		log.info("[verifyString] : " + verifyString);

		String signatureString = decodeBase64(signatureBase64);
		log.info("[signatureString] : " + signatureString);
//		String hash = BCrypt.hashpw(signatureString, BCrypt.gensalt());
//
//		log.info("[hash] : " + hash);


//		if(verifyString.matches(decodeBase64ToString(signatureBase64))) {
//		if(BCrypt.checkpw(verifyString, hash)) {
//		if(BCrypt.checkpw(signatureString, verifyString)) {
		if(BCrypt.checkpw(verifyString, signatureString)) {
			log.info("일치 합니다.");
		} else {
			log.info("일치 하지 않습니다.");
		}

		log.info("testAuthenticateByToken 종료");
	}

    private static byte[] hexify(String string) {
        return DatatypeConverter.parseHexBinary(string);
    }

	public String[] getJwtArray(String jwt) {
		String[] chunks = jwt.split("\\.");
		return chunks;
	}

	public String encodeBase64(String str) {
		return Base64.getEncoder().withoutPadding().encodeToString(str.getBytes());
	}

	public String decodeBase64(String str) {
		byte[] decodedBytes = Base64.getUrlDecoder().decode(str);
		return new String(decodedBytes);
	}

	public JwtDto decodeJwt(String jwt) {
		String[] chunks = jwt.split("\\.");
		Base64.Decoder decoder = Base64.getDecoder();

		String decodedHeader = new String(decoder.decode(chunks[0]));
		String decodedPayload = new String(decoder.decode(chunks[1]));
		String decodedVerifySignature = new String(decoder.decode(chunks[2]));

		log.info("[header] : " + decodedHeader);
		log.info("[payload] : " + decodedPayload);
		log.info("[verify signature] : " + decodedVerifySignature);

		JwtHeaderDto tokenHeader = new Gson().fromJson(
				decodedHeader, new TypeToken<JwtHeaderDto>() {}.getType()
		);

		JwtPayloadDto tokenPayload = new Gson().fromJson(
				decodedPayload, new TypeToken<JwtPayloadDto>() {}.getType()
		);

		JwtDto decodedJwt = new JwtDto(tokenHeader, tokenPayload, decodedVerifySignature);

		return decodedJwt;
	}

	public Claims tempGetClaimsByToken(String token) {
		Claims claims = Jwts.parserBuilder()
				.setSigningKey(DatatypeConverter.parseBase64Binary(SECRET_KEY))
				.build()
				.parseClaimsJws(token)
				.getBody();
		return claims;
	}

	public String refreshJwt(String jwt) {
		JwtDto jwtDto = decodeJwt(jwt);
		// @Todo 솔드아웃 서버로 토큰 갱신 요청 후 값 전달

		// @Todo 인증서버 호출 부분

		RestTemplate resTemplate = new RestTemplate();
		final String OAUTH_TOKEN_URL = "nginx/oauth/token";
//        final String header = "";

		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		header.setCacheControl("no-cache");

		return "";
	}
}
