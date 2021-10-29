package com.sintoburi.mapper;

import com.sintoburi.dto.TestDto;
import com.sintoburi.entity.TestEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(componentModel = "spring")
@Mapper
public interface TestMapper {
	
	TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);

	@Mapping(target = "id", constant = "0L")
	TestEntity testDtoToTestEntity(TestDto testDto);

	@Mapping(target = "img", expression = "java(testEntity.getProduct() + \".jpg\")")
	TestDto orderEntityToTestDto(TestEntity testEntity);
	
}
