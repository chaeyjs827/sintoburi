package com.sintoburi.service;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.transaction.Transactional;

import com.sintoburi.mapper.MemberMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sintoburi.dto.ApiReqResLogDto;
import com.sintoburi.dto.MemberDto;
import com.sintoburi.entity.MemberEntity;
import com.sintoburi.repository.MemberRepository;
import com.sintoburi.util.UtilLogger;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MemberService {

	private MemberRepository memberRepository;
	
	private UtilLogger utilLogger;
	
	@Transactional 
	public Long memberSignup(MemberDto memberDto) {
		MemberEntity memberEntity = MemberMapper.INSTANCE.dtoToEntity(memberDto);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		memberEntity.setPassword(passwordEncoder.encode(memberDto.getPassword()));
		memberEntity.setCreatedDate(LocalDateTime.now());
		memberEntity.setUpdatedDate(LocalDateTime.now());

		try {
			memberRepository.save(memberEntity);
//			return 1L;
			
		} catch(DataAccessException ex) {
			System.out.println(ex.getCause().getMessage());
		}
		return 1L;
		
//		return memberRepository.save(memberDto.toEntity()).getId();
	}
	
	@Transactional
	public Optional<MemberEntity> getMemberByUsername(String username) {
		return memberRepository.findByUsername(username);
	}
	
	public Optional<MemberEntity> getMemberById(Long id) {
		ApiReqResLogDto apiReqResLogDto = ApiReqResLogDto.builder()
				.apiMethodName("test")
				.apiName("test")
				.requestType("test")
				.requestUrl("test")
				.requestBody("test")
				.responseResult("test")
				.responseCode("test")
				.build();
		utilLogger.log(apiReqResLogDto);
		return memberRepository.findById(id);
	}
	
	@Transactional
	public Long userSignUp(String username, String email, String password) {
		MemberEntity entity = MemberEntity.builder()
				.username(username)
				.email(email)
				.password(password)
				.build();
		memberRepository.save(entity);
		return null;
	}
}
