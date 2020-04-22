package com.troyshoes.utility;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.troyshoes.domain.User;

@Component
public class MailConstructor {
	@Autowired
	private Environment env;
	
	public SimpleMailMessage constructResetTokenEmail(
			String contextPath, Locale locale, String token, User user, String password) {
		
		String url = contextPath = "/NewUser?token="+token;
		String message = "\n Please click on this link to verify your email and add your personal information.\nYou password is: \n"+password;
		SimpleMailMessage email = new SimpleMailMessage();
		email.setTo(user.getEmail());
		email.setSubject("Troy Sneaker Email Verify");
		email.setText(url+message);
		email.setFrom(env.getProperty("support.email"));
		return email;
	}
}
