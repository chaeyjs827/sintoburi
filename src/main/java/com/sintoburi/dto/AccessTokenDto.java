package com.sintoburi.dto;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.sintoburi.entity.AccessTokenEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Getter
public class AccessTokenDto {
	
	private String id;
	public Integer memberId;
	public Boolean isRevoked;
	private Date expiredDate;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;

}
