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

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/signup")
	@ResponseBody
	public String userSignup(MemberDto memberDto) {
		memberService.userSignup(memberDto);
		return "hello";
	}
	
	@GetMapping("/member/findById")
	@ResponseBody
	public Optional<MemberEntity> getMemberById(MemberDto memberDto) {
		Optional<MemberEntity> result = memberService.getMemberById(memberDto);
		return result;
	}
	
	@PostMapping("/member/login")
	@ResponseBody
	public Optional<MemberEntity> memberLogin(@RequestParam String username) {
		return memberService.getMemberByUsername(username);
	}
	
}
