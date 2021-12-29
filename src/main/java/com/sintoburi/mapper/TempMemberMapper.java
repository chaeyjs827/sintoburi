package com.sintoburi.mapper;

import com.sintoburi.common.mapper.BaseMapper;
import com.sintoburi.dto.MemberDto;
import com.sintoburi.entity.MemberEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
@Mapper
public interface TempMemberMapper extends BaseMapper<MemberDto, MemberEntity> {
	
	TempMemberMapper INSTANCE = Mappers.getMapper(TempMemberMapper.class);

	@Mapping(target = "id", constant = "0L")
	MemberEntity dtoToEntity(MemberDto memberDto);

	@Mapping(target = "id", constant = "0L")
	MemberDto entityToDto(MemberEntity memberEntity);
	
}
