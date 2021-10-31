package com.sintoburi.mapper;

import com.sintoburi.dto.MemberDto;
import com.sintoburi.dto.TestDto;
import com.sintoburi.entity.MemberEntity;
import com.sintoburi.entity.TestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
@Mapper
public interface MemberMapper {
	
	MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

	@Mapping(target = "id", constant = "0L")
	MemberEntity dtoToEntity(MemberDto memberDto);

	@Mapping(target = "id", constant = "0L")
	MemberDto entityToDto(MemberEntity memberEntity);
	
}
