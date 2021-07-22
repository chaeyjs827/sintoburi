package com.sintoburi.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sintoburi.dto.MemberDto;
import com.sintoburi.entity.MemberEntity;
import com.sintoburi.repository.MemberRepository;

@Service
public class MemberService {

	private MemberRepository memberRepository;
	
	@Transactional 
	public Long userSignup(MemberDto memberDto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberDto.setPassword(passwordEncoder.encode(memberDto.getPassword()));
		
//		memberRepository.save(memberDto.toEntity());
//		return null;
		return memberRepository.save(memberDto.toEntity()).getId();
	}
	
//	@Transactional
//	public Optional<MemberEntity> getMemberByUsername(String username) {
//		return memberRepository.findByUsername(username);
//	}
	
}
