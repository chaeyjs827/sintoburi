package com.sintoburi.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class MemberTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void apiMemberSignupTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/member/signup")
							.param("username", "campione")
							.param("password", "test"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println("result content : " + content);
	}
	
	@Test
	void apiMemberLoginTest() throws Exception {
		MvcResult result = mockMvc.perform(post("/api/member/login")
							.param("username", "admin"))
					.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println("result content : " + content);
	}
	
	@Test
	void apiUserSignUpTest() throws Exception {
		MvcResult result = mockMvc.perform(post("/api/user/signUp")
							.param("username", "admin")
							.param("password", "admin-password")
							.param("email", "admin@naver.com"))		
					.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println("result content : " + content);
	}
	
	@Test
	void apiMemberById() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/member/findById")
							.param("id", "1"))
					.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println("result content : " + content);
	}
}
