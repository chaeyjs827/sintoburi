package com.legacy;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.File;
import java.io.FileInputStream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
@AutoConfigureMockMvc
class FileUploadTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	
	/*
	 *	파일 업로드 테스트(O)
	 *	파일 서버 업로드 테스트(X) 
	 */
	
	@Test
	void uploadFile() throws Exception {
		File file = new File("C:\\Users\\chaey\\Downloads\\init_device.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		MockMultipartFile mockFile = new MockMultipartFile("file", file.getName(), "multipart/form-data", fileInputStream);
		
	   MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	    mockMvc.perform(multipart("/upload").file(mockFile))
	      .andExpect(status().isOk());
		
		/*
		MvcResult result = mockMvc.perform(((Object) post("/api/return-string"))
				.file(mockFile));
//				.param("file", new File("init_device.txt")))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
		*/
	}

}
