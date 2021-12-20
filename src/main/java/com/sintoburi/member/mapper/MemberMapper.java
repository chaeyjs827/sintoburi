package com.sintoburi.member.mapper;

import com.sintoburi.common.mapper.BaseMapper;
import com.sintoburi.dto.MemberDto;
import com.sintoburi.entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
@Mapper
public interface MemberMapper extends BaseMapper<MemberDto, MemberEntity> {
	
	MemberMapper INSTANCE = Mappers.getMapper(MemberMapper.class);

	@Mapping(target = "id", constant = "0L")
	MemberEntity dtoToEntity(MemberDto memberDto);

	@Mapping(target = "id", constant = "0L")
	MemberDto entityToDto(MemberEntity memberEntity);
	
}
