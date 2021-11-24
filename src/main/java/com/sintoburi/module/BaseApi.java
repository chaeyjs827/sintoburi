package com.sintoburi.module;

import com.sintoburi.dto.ApiResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author seongnamfc
 * @package com.sintoburi.module
 * @file BaseApi
 * @description
 * @date 2021/11/24
 */
@Slf4j
public class BaseApi<T> {
//    private final RestTemplate restTemplate;
//    public String host;
//
//    public BaseApi(RestTemplate restTemplate) {
//        this.restTemplate = restTemplate;
//    }
//
//    public ApiResponseDto get(String url) throws Exception {
//        return request(url, HttpMethod.GET, null, (Class<T>) Object.class);
//    }
//
//    public ApiResponseDto get(String url, Class<T> responseEntity) throws Exception {
//        return request(url, HttpMethod.GET, null, responseEntity);
//    }
//
//    public ApiResponseDto post(String url, Object body) throws Exception {
//        return request(url, HttpMethod.POST, body, (Class<T>) Object.class);
//    }
//
//    public ApiResponseDto post(String url, Object body, Class<T> responseEntity) throws Exception {
//        return request(url, HttpMethod.POST, body, responseEntity);
//    }
//
//    protected HttpHeaders getHeaders() {
//        return new HttpHeaders();
//    }
//
//    protected ApiResponseDto request(String url, HttpMethod httpMethod, Object body, Class<T> responseEntity)
//            throws Exception {
//
//        url = (this.host == null) ? url : (this.host + url);
//
//        HttpHeaders headers = getHeaders();
//        HttpEntity<Object> requestEntity = new HttpEntity<>(body, headers);
//
//        ResponseEntity<T> response = restTemplate.exchange(url, httpMethod, requestEntity, responseEntity);
//
//        return this.parseResponse(response);
//    }
//
//    private ApiResponseDto parseResponse(ResponseEntity<T> response) {
//        ApiResponseDto responseDto = new ApiResponseDto();
//        responseDto.setCode(response.getStatusCode().value());
//
//        if (response.getBody() instanceof LinkedHashMap) {
//            responseDto.setData(new JSONObject((LinkedHashMap) response.getBody()));
//        } else {
//            Map<String, String> responseMap = new HashMap<>();
//            responseMap.put("content", response.getBody().toString());
//            responseDto.setData(new JSONObject(responseMap));
//        }
//
//        return responseDto;
//    }
}
