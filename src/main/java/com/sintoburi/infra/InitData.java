package com.sintoburi.infra;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import com.sintoburi.entity.MemberEntity;
import com.sintoburi.repository.MemberRepository;

@Component
public class InitData {
	
	@Autowired
	private MemberRepository memberRepository;

    @PostConstruct
    private void initMember() throws IOException {
    	if(memberRepository.count() == 0) {
    		Resource resource = new ClassPathResource("h2-sample/member.csv");
    		List<MemberEntity> memberList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
    				.stream().skip(1).map(line -> {
    					String[] split = line.split(",");
    					return MemberEntity.builder().id(Long.parseLong(split[0])).username(split[1]).password(split[2]).build();
    				}).collect(Collectors.toList());
    		memberRepository.saveAll(memberList);
    	}
    }
}
