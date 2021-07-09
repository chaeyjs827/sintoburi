package com.legacy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.legacy.dto.MailDto;

@Service
public class MailService {

	@Autowired 
	private JavaMailSender mailSender;
	
    private static final String MAIL_SENDER_ADDRESS = "";

	public void sendMail(MailDto mailDto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("chaeyjs827@gmail.com");
		message.setFrom("chrisnorsamn@gmail.com");	// 생략 가능(생략하면 자동으로 application.yml의 username으로 셋팅됨)
		message.setSubject("subject");
		message.setText("set text");
		/*
//		message.setTo(mailDto.getAddress());
//		message.setFrom(MailService.MAIL_SENDER_ADDRESS);	// 생략 가능(생략하면 자동으로 application.yml의 username으로 셋팅됨)
		message.setSubject(mailDto.getTitle());
		message.setText(mailDto.getMessage());
		*/
		mailSender.send(message);
	}
}
