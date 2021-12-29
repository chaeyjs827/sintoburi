package com.sintoburi.mapper;

import com.sintoburi.dto.MemberDto;
import com.sintoburi.entity.MemberEntity;
import org.junit.Test;

public class MemberMapperTest {

	@Test
	public void sampleTest() throws Exception {
		final MemberDto memberDto = MemberDto.builder()
				.id(100L)
				.username("username")
				.email("email")
				.password("password")
				.build();

		MemberEntity memberEntity = TempMemberMapper.INSTANCE.dtoToEntity(memberDto);

		System.out.println("===== 테스트 종료 =====");

	}

}
