package com.sintoburi.dto;

import com.sintoburi.entity.ApiReqResLogEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiReqResLogDto {
	private Long id;
	private String apiName;
	private String apiMethodName;
	private String requestType;
	private String requestUrl;
	private String requestHeader;
	private String requestBody;
	private String responseResult;
	private String responseCode;
	
	public ApiReqResLogEntity toEntity() {
		return ApiReqResLogEntity.builder()
				.apiName(apiName)
				.apiMethodName(apiMethodName)
				.requestType(requestType)
				.requestUrl(requestUrl)
				.requestBody(requestBody)
				.responseResult(responseResult)
				.responseCode(responseCode)
				.build();
	}
	
	@Builder
	public ApiReqResLogDto(Long id, String apiName, String apiMethodName, String requestType,
						String requestUrl, String requestBody, String responseResult,
						String responseCode) {
		this.id = id;
		this.apiMethodName = apiMethodName;
		this.apiName = apiName;
		this.requestType = requestType;
		this.requestUrl = requestUrl;
		this.requestBody = requestBody;
		this.responseResult = responseResult;
		this.responseCode = responseCode;
	}
}
