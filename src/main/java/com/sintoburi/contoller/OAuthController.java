package com.sintoburi.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sintoburi.util.UtilJwt;

/*
 * 차후 OAuth 인증 관련 내용은 이부분에서 처리해야 함.
 * JWT 토큰도 추가해야함.
 */

@RestController
@RequestMapping("/api")
public class OAuthController {

	@Autowired
	private UtilJwt utilJwt;
	
	@GetMapping(value = "/oauth/login")
    @ResponseBody
	public void oauthLogin() {
		String accessToken = utilJwt.createToken("accessToken", 10000);
		String refreshToken = utilJwt.createToken("refreshToken", 200000);
		
		System.out.println("accessToken : " + accessToken);
		System.out.println("refreshToken : " + refreshToken);
		System.out.println("hahah");
	}
	
	
}
