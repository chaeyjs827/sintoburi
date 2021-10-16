package com.sintoburi.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import io.jsonwebtoken.ExpiredJwtException;

@SpringBootTest
@AutoConfigureMockMvc
public class JwtTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void jwtCreateTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/oauth/login")
				.param("username", "tester")
				.param("password", "password-test"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}	
	
	@Test
	public void authenticateTokenTest() throws Exception {

		try {
			MvcResult result = mockMvc.perform(get("/api/oauth/authenticate-token"))
					.andReturn();
			String content = result.getResponse().getContentAsString();
			System.out.println(content);
		} catch( Exception e) {
        	System.out.println("[에러 발생 in Test 메소] : Exception e");
        	e.printStackTrace();
        }

	}
	
	@Test
	public void jwtAuthenticateTest() {
		try {
			String jwt ="eyJ0eXBlIjoiand0IiwiYWxnIjoibm9uZSJ9.eyJ1c2VybmFtZSI6Ik9ILURBTU4iLCJhdCI6ImV5SjBlWEJsSWpvaWFuZDBJaXdpWVd4bklqb2lTRk15TlRZaWZRLmV5SnFkR2tpT2lJM05tVTVNV1F6WlMxbFpEbGpMVFEwTnpVdE9EaGlaUzFtT1RKbU0yVmhaV0UxTXpZaUxDSnBZWFFpT2pFMk16TTVORFkyT1Rrc0ltNWlaaUk2TVRZek16azBOalk1T1N3aVpYaHdJam94TmpNek9UUTJOekF6ZlEuREpkbktpdUNzRlVHTmhXZ3oySkdyX05fQ0d2S3Qza04tVlJmR18tLXJfbyIsInJ0IjoiZXlKMGVYQmxJam9pYW5kMElpd2lZV3huSWpvaVNGTXlOVFlpZlEuZXlKcWRHa2lPaUk1TldSbVkySmlOQzB5TmpRMExUUmtZVGN0WVRBMU55MDVORFEzTldWaU1XWTRPRElpTENKcFlYUWlPakUyTXpNNU5EWTJPVGtzSW01aVppSTZNVFl6TXprME5qWTVPU3dpWlhod0lqb3hOak16T1RRMk56QTNmUS56bVJGVjFfSTlRMUR5amZnYUl5aExUOG5Ec2xtRzVJbzJpRGFIYXVOeUtvIiwiaWF0IjoxNjMzOTQ2Njk5LCJuYmYiOjE2MzM5NDY2OTksImV4cCI6MTYzMzk0ODQ5OX0.";
			MvcResult result = mockMvc.perform(get("/api/oauth/authenticate")
						.param("token", jwt))
//						.param("token", at))
					.andReturn();
			String content = result.getResponse().getContentAsString();
			System.out.println("=============");
			System.out.println(content);
			System.out.println("=============");
		} catch( Exception e) {
        	System.out.println("[에러 발생 in Test 메소] : Exception e");
        	e.printStackTrace();
        }
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
