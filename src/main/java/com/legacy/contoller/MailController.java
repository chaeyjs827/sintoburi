package com.legacy.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.legacy.dto.MailDto;
import com.legacy.service.MailService;

@RestController
public class MailController {

	@Autowired
	private MailService mailService;
	
	@GetMapping("/api/mail")
	public void sendMail(MailDto mailDto) {
		mailService.sendMail(mailDto);
	}
	
}
