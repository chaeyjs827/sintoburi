package com.sintoburi.contoller.api;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sintoburi.common.dto.ApiReqResLogDto;
import com.sintoburi.service.ApiHttpExampleService;
import com.sintoburi.util.UtilLogger;
import com.sintoburi.util.UtilRsaKey;

@RestController
@RequestMapping(value = "/test/api")
public class TestController {
	
	@Autowired
	private UtilLogger utilLogger;
	
	@Autowired
	private ApiHttpExampleService apiHttpExampleService;
	
	@Autowired
	private UtilRsaKey utilRsaKey;
	
	@GetMapping(value = "/api-call-test")
	public ResponseEntity<String> connectToApiServerTest() {
		return apiHttpExampleService.connectToApiServer();
		
	}	
	@GetMapping(value = "/rsa-key")
	public KeyPair rsaKeyTest() {
		KeyPair keyPair = null;
		try {
			keyPair = utilRsaKey.generateRsaKeyPair();
			
			PublicKey publicKey = keyPair.getPublic();
			PrivateKey privateKey = keyPair.getPrivate();
			
			String plainText = "암호화 할 문자열";
			
			// Base64 인코딩된 암호화 문자열
			String encrypted = utilRsaKey.encryptRSA(plainText, publicKey);
			System.out.println("encrypted : " + encrypted);
			
			// 복호화
			String decrypted = utilRsaKey.decryptRSA(encrypted, privateKey);
			System.out.println("decrypted : " + decrypted);

			// 공개키를 Base64 인코딩한 문
			
			
		} catch(Exception e) {
			System.out.println(e.getStackTrace());
		}
		return keyPair;
	}
	
	@GetMapping(value = "/logger")
	public Long insertLog(ApiReqResLogDto apiReqResLogDto) {
		apiReqResLogDto = ApiReqResLogDto.builder()
		.apiMethodName("test")
		.apiName("test")
		.requestType("test")
		.requestUrl("test")
		.requestBody("test")
		.responseResult("test")
		.responseCode("test")
		.build();
		
		utilLogger.log(apiReqResLogDto);
		
		return null;
	}

	
	
}
