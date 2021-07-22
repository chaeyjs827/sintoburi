package com.sintoburi.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sintoburi.dto.MemberDto;
import com.sintoburi.service.MemberService;

@RestController
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
	
//	@GetMapping("/login")
//	@ResponseBody
//	public Optional<MemberEntity> apiLogin(@RequestParam String username) {
//		return memberService.getMemberByUsername(username);
//	}
	
}
