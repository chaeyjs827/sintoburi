package com.sintoburi.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.sintoburi.entity.MemberEntity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberMemoDto {
	
    private Long id;
	private Long memberId;
	private Long adminId;
	private String memo;
	private LocalDateTime createdDate;
	private LocalDateTime updatedDate;
	
    public MemberEntity toEntity() {
    	return MemberEntity.builder()
    			.id(id)
    			.build();
    }
    
    @Builder
    public MemberMemoDto(Long id) {
    	this.id = id;
    }

}
