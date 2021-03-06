package com.sintoburi.contoller.api;

import java.util.Optional;

import com.sintoburi.auth.AuthRequired;
import com.sintoburi.config.res.ApiResponse;
import com.sintoburi.model.MemberModel;
import com.sintoburi.service.impl.LegacyRedisService;
import com.sintoburi.service.impl.StRedisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sintoburi.dto.MemberDto;
import com.sintoburi.entity.MemberEntity;
import com.sintoburi.service.TempMemberService;
import com.sintoburi.util.UtilJwtAuth;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class TempMemberController {

	private TempMemberService memberService;
	private UtilJwtAuth utilJwt;
	private StRedisService stRedisService;
	private LegacyRedisService legacyRedisService;

//	public String memberSignUp(@ModelAttribute MemberDto memberDto) {
//	public String memberSignUp(MemberDto memberDto) {
	@PostMapping("/member/sign-up")
	@ResponseBody
	public ResponseEntity memberSignUp(@RequestBody MemberDto memberDto) {
		try {
			// 유저 정보 유효성검사

			// 1. 아이디 중복 확인(탈퇴 계정 포함)
			// 2. 이메일 중복 확인(탈퇴 계정 포함)

			// To-Do Oauth계정 인증 내용
			memberService.memberSignup(memberDto);
			return ResponseEntity.ok().body(ApiResponse.builder()
					.data(null)
					.build());
//			return "hello";
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@GetMapping("/member/find-by-id")
	@ResponseBody
	@AuthRequired
	public Optional<MemberEntity> getMemberById(@RequestParam String id) {

		MemberModel member = memberService.getTest();

		stRedisService.save("green", "haha", "hoho");
		legacyRedisService.save("sum41", "have", "family");
		Optional<MemberEntity> result = memberService.getMemberById(Long.parseLong(id));
		return result;
	}
	
	@PostMapping("/member/login")
	@ResponseBody
	public Optional<MemberEntity> memberLogin(@RequestParam String username) {
		
		// Id/파라미터 null 체크
		if(username.isEmpty()) {
			
		}
		
//		if(password.isEmpty()) {
//			
//		}
		
		
		//블락 유저 검증 로직
		
		//

		// 유저 존재 여부 확인

		
		// 유저 정보 유효성 검증 이후 jwt 토큰 생성
		Boolean testBoolean = memberService.checkMember(username);
//		if(memberService.checkMember(username)) {
//			System.out.println("유저 없음");
//		}

		if(testBoolean) {
			return null;
//			return Optional<MemberEntity.builder()
//					.email("값이 없수광")
//					.build()>;
		} else {
			String jwt = utilJwt.createJwtToken(username);
			return memberService.getMemberByUsername(username);
		}

	}
	
	@PostMapping("/member/sign-up-test")
	@ResponseBody
	public String userSignUp(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
		memberService.userSignUp(username, email, password);
		// 유저 정보 유효성검사
		
		// 1. 아이디 중복 확인(탈퇴 계정 포함)
		// 2. 이메일 중복 확인(탈퇴 계정 포함)
		
		// To-Do Oauth계정 인증 내용
		
		return null;
	}
	
	@PostMapping("/user/findId")
	@ResponseBody
	public String userFindId(@RequestParam String username, @RequestParam String password, @RequestParam String email) {
		memberService.userSignUp(username, email, password);
		return null;
	}
	
}
