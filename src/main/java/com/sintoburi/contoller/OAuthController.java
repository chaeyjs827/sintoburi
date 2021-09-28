package com.sintoburi.contoller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sintoburi.util.UtilJwt;
import com.sintoburi.util.UtilRedis;

import io.jsonwebtoken.Claims;

/*
 * 차후 OAuth 인증 관련 내용은 이부분에서 처리해야 함.
 * JWT 토큰도 추가해야함.
 */

@RestController
@RequestMapping("/api")
public class OAuthController {

	@Autowired
	private UtilJwt utilJwt;
	
	@Autowired
	private UtilRedis utilRedis;
	
	@GetMapping(value = "/oauth/login")
    @ResponseBody
	public Map<String, String> oauthLogin() {
		String accessToken = utilJwt.authenticateToken("accessToken", 10000);
		String refreshToken = utilJwt.authenticateToken("refreshToken", 200000);
//		String getAccessToken = utilRedis.getToken("accessToken");
//		String getRefreshToken = utilRedis.getToken("refreshToken");
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("access-token", accessToken);
		result.put("refresh-token", refreshToken);
//		result.put("get-access-token", getAccessToken);
//		result.put("get-refresh-token", getRefreshToken);
		return result;
	}
	
	@GetMapping(value = "/oauth/authenticate-token")
    @ResponseBody
	public Map<String, String> authenticateToken() {
		String jwt = utilJwt.authenticateToken("OH-DAMN", 262974600);	// 262974600 is a month
		
		Map<String, String> result = new HashMap<String, String>();
		result.put("jwt", jwt);
		return result;
	}
	
	@GetMapping(value = "/oauth/authenticate")
	@ResponseBody
	public String oauthAuthenticate(@RequestParam String token) {
		String result = utilJwt.authenticateByToken(token);
		return result;
	}
	
	@GetMapping(value = "/oauth/getClaimsByToken")
	@ResponseBody
	public Claims getClaimsByToken(@RequestParam String token) {
		Claims result = utilJwt.getClaimsByToken(token);
		return result;
	}
}
