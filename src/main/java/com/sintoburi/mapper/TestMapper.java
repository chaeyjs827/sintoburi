package com.sintoburi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TestMapper {
	
	TestMapper INSTANCE = Mappers.getMapper(TestMapper.class);
	
	
}
