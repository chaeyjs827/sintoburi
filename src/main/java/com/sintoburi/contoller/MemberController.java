package com.sintoburi.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sintoburi.dto.MemberDto;
import com.sintoburi.entity.MemberEntity;
import com.sintoburi.service.MemberService;
import com.sintoburi.util.UtilJwt;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private UtilJwt utilJwt;
	
//	public String memberSignUp(@ModelAttribute MemberDto memberDto) {
//	public String memberSignUp(MemberDto memberDto) {
	@PostMapping("/member/sign-up")
	@ResponseBody
	public void memberSignUp(@RequestBody MemberDto memberDto) {
		try {
			// 유저 정보 유효성검사

			// 1. 아이디 중복 확인(탈퇴 계정 포함)
			// 2. 이메일 중복 확인(탈퇴 계정 포함)

			// To-Do Oauth계정 인증 내용
			memberService.memberSignup(memberDto);
//			return "hello";
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/member/findById")
	@ResponseBody
	public Optional<MemberEntity> getMemberById(@RequestParam String id) {
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
		
		
		// 유저 정보 유효성 검증 이후 jwt 토큰 생성
		
		String jwt = utilJwt.createJwtToken(username);
		
		return memberService.getMemberByUsername(username);
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
