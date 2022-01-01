package com.sintoburi.util;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.sintoburi.common.dto.ApiReqResLogDto;
import com.sintoburi.repository.ApiReqResLogRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class UtilLogger {
	
	private ApiReqResLogRepository apiReqResLogRepository;
	
	@Transactional
	public void log(ApiReqResLogDto apiReqResLogDto) {
		try {
			apiReqResLogRepository.save(apiReqResLogDto.toEntity());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
