package com.Telusko.Security.SecureApp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/rest")
public class HomeController {
	 
	@Autowired
	UserRepository userRepository;

	
	@GetMapping("/home")
	public String hello()
	{
		return "Hello";
	}
	
	@GetMapping("/login-success")
	public String login()
	{
		return "login successfull";
	}
	
	@GetMapping("/logout-success")
	public String logout()
	{
		return "logout successfull";
	}

	@PostMapping("/add")
	public String addUser(@RequestBody User user)
	{
		userRepository.save(user);
		return "user added successfull";
	}
	
	@GetMapping("/allusers")
	public List<User> allUser()
	{
		return userRepository.findAll();
		
	}
}
