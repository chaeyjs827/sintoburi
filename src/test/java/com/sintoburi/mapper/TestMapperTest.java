package com.sintoburi.mapper;

import com.sintoburi.dto.TestDto;
import com.sintoburi.entity.TestEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDateTime;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class TestMapperTest {

	@Test
	public void sampleTest() throws Exception {
		final TestDto testDto = TestDto.builder()
				.name("name")
				.product("product")
				.price(100)
				.address("address")
				.img("img")
				.orderedTime(LocalDateTime.now())
				.build();

		System.out.println(testDto.toString());

		TestEntity testEntity = TestMapper.INSTANCE.testDtoToTestEntity(testDto);

		System.out.println("===== 테스트 시작 =====");

		System.out.println(testEntity.toString());
//		assertNotNull(testDto);
//
//		assertEquals("a", "a");

		System.out.println("===== 테스트 종료 =====");

	}

}
