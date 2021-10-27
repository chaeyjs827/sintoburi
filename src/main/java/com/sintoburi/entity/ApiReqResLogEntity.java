package com.sintoburi.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "api_req_res_log")
@Entity
//@Builder
public class ApiReqResLogEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 15, nullable = false)
	private String apiName;
	
	@Column(length = 50, nullable = false)
	private String apiMethodName;
	
	@Column(length = 10, nullable = false)
	private String requestType;
	
	@Column(length = 500, nullable = false)
	private String requestUrl;
	
	@Column(length = 500, nullable = true)
	private String requestHeader;
	
	@Column(length = 500, nullable = false)
	private String requestBody;
	
	@Column(length = 2000, nullable = false)
	private String responseResult;
	
	@Column(length = 10, nullable = false)
	private String responseCode;
	
//	@Column(name = "timestamp", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//	private Date createdDate;
//	
//	@Column(name = "timestamp", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
//	private Date updatedDate;
	
	@Builder
	public ApiReqResLogEntity(Long id, String apiName, String apiMethodName,
			String requestType, String requestUrl, String requestHeader,
			String requestBody, String responseResult, String responseCode) {
		this.id = id;
		this.apiName = apiName;
		this.apiMethodName = apiMethodName;
		this.requestType = requestType;
		this.requestUrl = requestUrl;
		this.requestHeader = requestHeader;
		this.requestBody = requestBody;
		this.responseResult = responseResult;
		this.responseCode = responseCode;
	}
	
}
