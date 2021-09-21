package com.sintoburi.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiHttpExampleService {

	public MultiValueMap<String, String> connectToApiServer() {
	
		MultiValueMap<String, String> requestBody = new LinkedMultiValueMap<>();
		requestBody.add("", "");
		
		HttpHeaders requestHeader = new HttpHeaders();
		requestHeader.add("", "");
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(requestBody, requestHeader);
		
		RestTemplate rt = new RestTemplate();
		
		ResponseEntity<String> response = rt.exchange(
                "https://{요청할 서버 주소}", //{요청할 서버 주소}
                HttpMethod.POST, //{요청할 방식}
                entity, // {요청할 때 보낼 데이터}
                String.class // {요청시 반환되는 데이터 타입}	
		);
		
		return requestBody;
		
	}
	
}
