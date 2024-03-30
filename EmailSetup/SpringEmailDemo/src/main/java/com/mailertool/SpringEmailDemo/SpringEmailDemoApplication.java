package com.mailertool.SpringEmailDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringEmailDemoApplication {

//	@Autowired
//	private EmailSenderService EmailSenderService;
//	
//	@Autowired
//	ReadCsvFile readcsv;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringEmailDemoApplication.class, args);

	   }
		
//	@EventListener(ApplicationReadyEvent.class)
//	public void sendEmail()
//	{
//		EmailSenderService.sendEmail("averne27@in.ibm.com","Subject of email","Body of Email");
//	}
	
//	@EventListener(ApplicationReadyEvent.class)
//	public void readCsv()
//	{
//		readcsv.readCsv();
//	}
	
}
