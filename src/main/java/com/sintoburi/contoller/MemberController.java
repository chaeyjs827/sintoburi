package com.sintoburi.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@GetMapping("/member/signup")
	@ResponseBody
	public String userSignup(MemberDto memberDto) {
		memberService.userSignup(memberDto);
		return "hello";
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
		
		String jwt = utilJwt.tempCreateToken(username, 3600);
		
		return memberService.getMemberByUsername(username);
	}
	
}
