package com.microservices.usermicroservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserServiceImpl UserService;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/{user_id}")
	public User getUser(@PathVariable("user_id") Long id)
	{
		//User user2 = UserService.getUser(id);
		
		List<Contacts> contacts = restTemplate.getForObject("http://contact-service/contacts/"+id, List.class);

		//java.util.List<Contacts> contacts = (java.util.List<Contacts>) this.RestTemplate.getForObject("http://localhost:9000/contacts/"+id, List.class);
		User user = UserService.getUser(id);
		user.setContacts(contacts);
		return user;
	}

}
