package com.sintoburi.contoller.api;

import java.util.HashMap;
import java.util.Map;

import com.sintoburi.config.res.ApiResponse;
import com.sintoburi.dto.auth.JwtDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sintoburi.util.UtilJwtAuth;

import io.jsonwebtoken.Claims;

/*
 * 차후 OAuth 인증 관련 내용은 이부분에서 처리해야 함.
 * JWT 토큰도 추가해야함.
 */

@RestController
@RequestMapping("/api")
@Slf4j
public class OAuthController {

	@Autowired
	private UtilJwtAuth utilJwt;
	
	@GetMapping(value = "/oauth/login")
    @ResponseBody
	public Map<String, String> oauthLogin(@RequestParam String username,
									@RequestParam String password) {
		log.debug("controller 실행");
		String jwt = utilJwt.createJwtToken("log-test");

		Map<String, String> result = new HashMap<String, String>();
		result.put("jwt", jwt);

		log.debug("return");
		return result;
	}
	
	@GetMapping(value = "/oauth/authenticate-token")
    @ResponseBody
	public Map<String, String> authenticateToken() {
		String jwt = utilJwt.createJwtToken("test-username");	
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("jwt", jwt);
		return result;
	}
	
	@GetMapping(value = "/oauth/authenticate")
	@ResponseBody
	public ResponseEntity oauthAuthenticate(@RequestParam String token) {
		Boolean result = utilJwt.authenticateByToken(token);
		return ResponseEntity.ok().body(ApiResponse.builder()
				.data(result)
				.build());
	}

	@GetMapping(value = "/oauth/decode-jwt")
	@ResponseBody
	public ResponseEntity oauthDecodeJwt(@RequestParam String jwt) {

		// jwt 토큰 타입은 정형화된 형태가 아님.. 그래서 decode를 해줘야함
		JwtDto jwtToken = utilJwt.decodeJwt(jwt);

		// access-token 유효성 검사
		Boolean authenticateToken = utilJwt.authenticateByToken(jwtToken.getPayload().getAt());

//		Map<String, Object> payload = result.get("payload");

//		result.get("payload").
//		String at = result.get("at") == null ? "" : (String) result.get("a");
//		utilJwt.authenticateByToken(at);

		return ResponseEntity.ok().body(ApiResponse.builder()
				.data(jwtToken)
				.build());
	}
	
	@GetMapping(value = "/oauth/getClaimsByToken")
	@ResponseBody
	public Claims getClaimsByToken(@RequestParam String token) {
		Claims result = utilJwt.tempGetClaimsByToken(token);
		return result;
	}

	@GetMapping(value = "/oauth/test-token")
	@ResponseBody
//	@AuthRequired
	public void getTestToken(@RequestParam String token) {
		utilJwt.testAuthenticateByToken(token);
		log.info("have a nice day :) ");
	}
}