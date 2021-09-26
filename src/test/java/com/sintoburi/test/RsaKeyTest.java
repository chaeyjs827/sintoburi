package com.sintoburi.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@SpringBootTest
@AutoConfigureMockMvc
public class RsaKeyTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void resKeyTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/test/api/rsa-key"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
}
