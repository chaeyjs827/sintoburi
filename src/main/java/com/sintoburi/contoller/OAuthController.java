package com.sintoburi.contoller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * 차후 OAuth 인증 관련 내용은 이부분에서 처리해야 함.
 * JWT 토큰도 추가해야함.
 */

@RestController
@RequestMapping("/api")
public class OAuthController {

	@PostMapping(value = "/api/oauth/login") 
	public void oauthLogin() {
		
	}
	
}
