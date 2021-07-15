package com.sintoburi.util;

import org.springframework.stereotype.Component;

/*
 * 1. 로그인	-> Access-Token
 * 			-> Refresh-Token(DB에 저장)
 * 			두개 모두 쿠키게 저장됨
 * 
 * 2. API 요청을 하면 토큰의 유효성 검사를 하는 미들웨어가 필요함
 * 		case1 : access-token(만료), refresh-token(만료) => 에러
 * 		case2 : access-token(유효), refresh-token(만료) => refresh-token 재발급
 * 		case3 :	access-token(만료), refresh-token(유효) => access-token 재발급
 * 		case4 : access-token(만료), refresh-token(만료) => 다음 로직 실행
 * 
 * 3. 로그아웃 하면 access-token과 refresh-token 모두 만료
 * 
 * 4. 발급된 토큰을 request-header에 담아 API 요청을 하면 됨;
 */

@Component
public class UtilJwt {

}
