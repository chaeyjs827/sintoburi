package com.sintoburi.contoller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sintoburi.dto.MailDto;
import com.sintoburi.service.MailService;

@RestController
public class MailController {
	
	@Autowired
	private MailService mailService;
	
	@GetMapping("/api/mail")
	public void sendMail(MailDto mailDto) {
		mailService.sendMail(mailDto);
	}
	
	
}
