package com.sintoburi.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sintoburi.entity.MemberEntity;
import com.sintoburi.service.MemberService;

@RestController
@RequestMapping("/api")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/test")
	@ResponseBody
	public String getMemberByUsername(@RequestParam String username) {
		return "hello";
	}
//	@GetMapping("/test")
//	@ResponseBody
//	public Optional<MemberEntity> getMemberByUsername(@RequestParam String username) {
//		return memberService.getMemberByUsername(username);
//	}
	
}
