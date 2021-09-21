package com.sintoburi.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sintoburi.dto.ApiReqResLogDto;
import com.sintoburi.service.ApiHttpExampleService;
import com.sintoburi.util.UtilLogger;

@RestController
@RequestMapping(value = "/test/api")
public class TestController {
	
	@Autowired
	private UtilLogger utilLogger;
	
	@Autowired
	private ApiHttpExampleService apiHttpExampleService;
	
	
	@GetMapping(value = "api-call-test")
	public ResponseEntity<String> connectToApiServerTest() {
		return apiHttpExampleService.connectToApiServer();
		
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
