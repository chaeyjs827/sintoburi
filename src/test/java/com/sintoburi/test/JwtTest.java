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
public class JwtTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void jwtCreateTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/oauth/login"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	@Test
	public void jwtAuthenticateTest() throws Exception {
		String rt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZWZyZXNoVG9rZW4iLCJleHAiOjE2MjY3OTAxMjR9.w83FbpsOHG9P3we-C3mlQCyktm8jw4E-En4vrs4s7X0";
		String at = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhY2Nlc3NUb2tlbiIsImV4cCI6MTYyNjc4OTkzNH0.7WXLvHFwPMVcY-U3eTtcaiUAN7LeOg69mlPKVgXzrrI";
		MvcResult result = mockMvc.perform(get("/api/oauth/authenticate")
					.param("token", rt))
//					.param("token", at))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	@Test
	public void jwtGetCalimsByTokenTest() throws Exception {
		String rt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZWZyZXNoVG9rZW4iLCJleHAiOjE2MjY3OTAzOTV9.lGZn-wHOf_I9qxoHsoNyGuBRAhqFQbsjAGM8HCXzB74";
		String at = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhY2Nlc3NUb2tlbiIsImV4cCI6MTYyNjc4OTkzNH0.7WXLvHFwPMVcY-U3eTtcaiUAN7LeOg69mlPKVgXzrrI";
		MvcResult result = mockMvc.perform(get("/api/oauth/getClaimsByToken")
				.param("token", rt))
//					.param("token", at))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	
	
}
