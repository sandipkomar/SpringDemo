package com.spaient.kafka.service;

public class EmailServiceFactory {
	public static EmailService getEmailService(String email) {
		if(email.equalsIgnoreCase("Gmail")) return new GMailServiceImpl();
		if(email.equalsIgnoreCase("Ymail")) return new YMailServiceImpl();
		if(email.equalsIgnoreCase("Cmail")) return new CMailServiceImpl();
		return null;
	}
}
