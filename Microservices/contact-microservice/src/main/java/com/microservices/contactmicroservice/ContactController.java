package com.microservices.contactmicroservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {
	
	@Autowired
	ContactService  ContactService;
	
	@GetMapping("/{user_id}")
	public List<Contacts> getAllContacts(@PathVariable("user_id") Long id)
	{
		return ContactService.getContacts(id);
		
	}

}
