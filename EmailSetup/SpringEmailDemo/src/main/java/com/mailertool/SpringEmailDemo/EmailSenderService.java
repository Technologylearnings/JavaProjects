package com.mailertool.SpringEmailDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderService {

	@Autowired
	public JavaMailSender mailSender;
	
	public void sendEmail(String toEmail, String subject, String body)
	{
		SimpleMailMessage message= new SimpleMailMessage();
		message.setFrom("archanavernekar5@gmail.com");
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
		
		System.out.println("Mail sent succesfully");
	}

}
