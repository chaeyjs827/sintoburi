package com.sintoburi.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sintoburi.entity.MemberEntity;
import com.sintoburi.service.MemberService;

@RestController
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member-by-username")
	@ResponseBody
	public Optional<MemberEntity> getMemberByUsername(String username) {
		username = "1";
		return memberService.getMemberByUsername(username);
	}
	
}
