package com.microservices.usermicroservice;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	
	List<User> list= List.of(
			new User(123L,"Archana"),
			new User(124L,"Arpita"),
			new User(125L,"Aditya")		
			);
	
	
	@Override
	public User getUser(Long id) {		
		 User user = list.stream().filter(u->u.getUserId().equals(id)).findAny().orElse(null);
		 return user;
	}

}
