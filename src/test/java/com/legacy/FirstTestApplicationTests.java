package com.legacy;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.legacy.contoller.SampleController;

@SpringBootTest
@AutoConfigureMockMvc
class FirstTestApplicationTests {

	@Autowired
	private SampleController sampleController;
	
	@Autowired
	private MockMvc mockMvc;
	
	// Send Mail
	@Test
	void sendMail() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/mail"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	// 문제 1번
	@Test
	void firstTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/first"))
		.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	// 문제 2번
	@Test
	void secondTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/second"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

	// 문제 3번
	@Test
	void thirdTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/third"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	// 문제 4번
	@Test
	void fourthTest() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/fourth")
							.param("brName", "하이"))
							.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	@Test
	void accountName() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/findByAccountName")
				.param("accountName", "제이"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	@Test
	void findAllbyAllCondition() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/findAllbyAllCondition")
				.param("accountName", "제이")
				.param("accountNo", "11111111")
				.param("branchCode", "A"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	@Test
	void testFindAllInAccount() throws Exception {
		MvcResult result = mockMvc.perform(get("/api/testFindAllInAccount")
				.param("accountName", "제이"))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}

}
