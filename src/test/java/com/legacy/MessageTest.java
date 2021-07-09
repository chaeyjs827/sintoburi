package com.legacy;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.legacy.contoller.MessageController;

@SpringBootTest
@AutoConfigureMockMvc
class MessageTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	void returnString() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/return-string"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	@Test
	void returnList() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/return-list"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	@Test
	void returnMap() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/return-map"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

}
