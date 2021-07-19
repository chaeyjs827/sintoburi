package com.sintoburi.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void jwtTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/oauth/login"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
}
