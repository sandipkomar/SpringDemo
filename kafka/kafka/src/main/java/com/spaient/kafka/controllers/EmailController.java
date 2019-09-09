package com.spaient.kafka.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spaient.kafka.service.EmailServiceFactory;
import com.spaient.kafka.service.EmailService;

@RestController
public class EmailController {
	
	@GetMapping(value = "/sendMail")
	public String sendMail() {
		EmailService emailService = EmailServiceFactory.getEmailService("Gmail");
		if(emailService.sendMail().equalsIgnoreCase("Send")) return "Success";		
		return "Failure";
	}
}
                                                  