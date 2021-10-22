package com.sintoburi.dto;

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
public class AccessTokenDto {
    private Long id;
    
    public MemberEntity toEntity() {
    	return MemberEntity.builder()
    			.id(id)
    			.build();
    }
    
    @Builder
    public AccessTokenDto(Long id) {
    	this.id = id;
    }

}
