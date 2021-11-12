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
		String jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdCI6ImV5SjBlWEFpT2lKS1YxUWlMQ0poYkdjaU9pSlNVekkxTmlKOS5leUpoZFdRaU9pSXlJaXdpYW5ScElqb2lOakExT0dFell6VXlOMkZqTWpWaU9EUTNPVGd6TmpGaVltTm1OekZoTldZMVl6UTVPRE5tWldRMk5qWXhNakE1WWpKalpEQm1ZVFk0TnpCaE1qUmhNbUZtTnpZek1HWXlZV05oWXpNNFl6Z2lMQ0pwWVhRaU9qRTJNelkyTnpVek1EUXNJbTVpWmlJNk1UWXpOalkzTlRNd05Dd2laWGh3SWpveE5qWTRNakV4TXpBMExDSnpkV0lpT2lJeElpd2ljMk52Y0dWeklqcGJYWDAuSmlfbzhwNzFYWEpZZDNRM2xQZW9mSUlPVEU0OV9zLWlJRnV5eGdLTVZsSHVzR0hHcFBObGN4aVhBRzhsVGMxdkZNQ2hTcGZDblJkT2QyamF0SFBpdFBRSWEzTmtLbi1jV3RqYmdtVGFvekNGSzRIOExyRHJFQ1d3MFlDeEFMLWZQSURmWll6QklhNDV0MFU4X0c1aUJCVzhoSmphSVBTTmJ6MzFkU0l0bXlZSS1VWE5mZnM5QkVGaVlWdDVlMVJhX0hLanhqckdNbzluRDc4MERYdHZHZ1VYXzk1OTR5MTVXUTRjVDNhNzFvQ1hYVWNhdjRyQ1A2blhVUEg1aUtKRmZ2SEVRYmQ0ZGd3cUNiSzhSX0Vqd19ZV3gzWnVCdVFlYTRBaVBpVXZ6X1phMnV1YkNIbTRLbkpKVjVOUGEwbzRuX09NYm1kQTAzSndlOUpPbm9OYTRfR1JKbHNOVGtSVWhRclcybHY1bEpuWkZnUGJhNGFHS29jcjZKUWs1aUpaZnpXcjk2dTRVMFBsekt2clVqQUJMUTk1Y1Y2R2lIRnpDa0FSR1FILXJEZmRtd3ZvamUxNFAwZjN2YUltM1hETFRxMlFVUWFoSHhaNTRDWEx0dXF2cVJXcjd1c0RRelJDd3d6U3o3bm9TZm1zMHlZelE4LUdDbmY3bHlEZnJYSEVLUTUxR2F5UGczaG50ckNXdzVZRnBzeEFVYllNcWxhZVVVdmNUZ1pXYy1kaURvaVhxS01lTi1nMEs5NmVPbnBEZzY1TDJKUWpNZW0zN3h5ZUItdnd0NlU1OWJVQndHYlZMaDRXR3htNWdPalRuOWFVOUY2bFUybnVyY1Nza2k2VlJTWDVzbm5la1ZhSVhjcmVlSFpsazhSQkhHR2I0ZWJyMkZ5VXQzTFFjRlEiLCJydCI6ImRlZjUwMjAwOTQwNTg2NWVlYzMyNjhkYzk3NmFlNjZjMWY5YjRlNjNlODFmMjU1NzU1ZDQ5NTQyNWI0MGRhMjBiMzRkMzdjNjQwNDJhNmJhMDNhZWE5YjA3NmRkZGZlOGQwNjBiNTgwYmUyMzA0MzNkYzVkN2RlNjg3NDdjZjVlNGU5MjNlZjA0N2I5MjU3OGQ1ZjIwOGI2ODg1NTc0NWZlN2FlODY5ZjVmN2U3NDliN2NhODRiMWIwNzhmZThmMzg1ODE5ZTIyMzFmMWFlMmM3OWZhYjdkOTRiZDU1NWFlYTljMzhkOTg0NGUxNTVjNDhkYzIwYjgxMzc3MGQwOGY3ZmMyOGNhNzE3MzIyODUyNWU4YjJjZmZkN2I2MjRmMTRhNjgxN2FkMGZmYWIxYTA3ZDg2ZmM5OGI1M2UyODE4MWI3MmMyMDFjZDU3MzgzOTI3NjM5Nzg1ZTJhMmJmNzdlODA0Mzc5N2FkNGFkNGQxZWY2NjdiMDZkNTJmNTNkN2U1MTM1ZGMxNzRkMzBlNjU3ZjU3MWRlODU3NjVkOTY4MTE5MjdmNDQ0Yzg2YjkzZjJhOTk5OTg4ZDE5ZDJiM2Y3NGY2NTI2M2JiNGYwNDcwOWU4MmUyMzRkNTJhMjcyYjI0MmRhNmY3OTgzYWQ5OGRmMTUzY2Q0MTNlMjQwMTk4NWZmMWY3YWM5NjBjMjA0MzIxYjJlNzliYzdlZDZiY2UzNDRkMDA0YTkzMDJmZDAyMGM4MmQzY2RkY2E2MzFjMDNlNzg4NDJkMTQ1NGQzZGE0OTQ2ODdmYWVjYWUxMDdkZGM5YzlhYzNkZDg2OGFiYmM1YjRmNmI2OWVkZGNhNGE3NDExOTM4ZTFjMmY3ODIzZjNlNjIxNGFkY2YxZjUxMTA4YWE0ZTQzMzc4MTRjZmM2ZWNiMDAzZmE5YWM3ZjMzYzIiLCJpZCI6InNfY3VzdG9tZXIiLCJpc0V4cGlyZWQiOmZhbHNlLCJjcmVhdGVkX2F0IjoiMjAyMTExMTIwOTAxNDUiLCJpYXQiOjE2MzY2NzUzMDUsImV4cCI6MTYzOTI2NzMwNX0.BoTPKS1kghe9UBheeb6d4F4ikoJENfBmxU-rnSH5_Ng";
		String rt = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyZWZyZXNoVG9rZW4iLCJleHAiOjE2MjY3OTAzOTV9.lGZn-wHOf_I9qxoHsoNyGuBRAhqFQbsjAGM8HCXzB74";
		String at = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhY2Nlc3NUb2tlbiIsImV4cCI6MTYyNjc4OTkzNH0.7WXLvHFwPMVcY-U3eTtcaiUAN7LeOg69mlPKVgXzrrI";
		MvcResult result = mockMvc.perform(get("/api/oauth/getClaimsByToken")
				.param("token", jwt))
//					.param("token", at))
				.andReturn();
		String content = result.getResponse().getContentAsString();
		System.out.println(content);
	}
	
	
	
}
