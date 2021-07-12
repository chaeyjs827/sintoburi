package com.sintoburi.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.sintoburi.entity.MemberEntity;
import com.sintoburi.repository.MemberRepository;

@Service
public class MemberService {

	private MemberRepository memberRepository;
	
	@Transactional
	public Optional<MemberEntity> getMemberByUsername(String username) {
		return memberRepository.findByUsername(username);
	}
	
}
