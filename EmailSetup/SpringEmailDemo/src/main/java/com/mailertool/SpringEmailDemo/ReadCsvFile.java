package com.mailertool.SpringEmailDemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;


@Component
public class ReadCsvFile {
	
	@Autowired
	public JavaMailSender mailSender;
	
	String file="src\\csvfile1.csv";
	BufferedReader reader=null;
	CSVReader reader1=null;
	String[] line;

	String email,subject,body;
	
	public void readCsv() {
	try {
		//reader = new BufferedReader(new FileReader(file));
		reader1 = new CSVReader(new FileReader(file));
		while((line=reader1.readNext())!=null)
		{
			SimpleMailMessage message= new SimpleMailMessage();
			
				email=String.format("<%s>", line[0]);//line[0].format(body, line)
				subject=line[1];
				body=line[2];
				
				message.setFrom("archanavernekar5@gmail.com");
				message.setTo(email);
				message.setText(body);
				message.setSubject(subject);
				System.out.println(message);
				mailSender.send(message);
				System.out.println("Mail sent succesfully!!!");
//				System.out.println(email+"   "+subject+"   "+body);
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Error!!!!!!!!!!!!!");
		
	}
	finally {
		try {
			reader1.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
	
	
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
