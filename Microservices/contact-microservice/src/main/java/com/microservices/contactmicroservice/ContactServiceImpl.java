package com.microservices.contactmicroservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


@Service
public class ContactServiceImpl implements ContactService {

	
	public List<Contacts> list=List.of(
			new Contacts(1,"IE","IE@abc",123L),
			new Contacts(2,"Momy","Momy@abc",124L),
			new Contacts(3,"Rohan","Rohan@abc",125L),
			new Contacts(4,"Momie","IE@abc",123L),
			new Contacts(5,"Rupa","Momy@abc",123L),
			new Contacts(6,"Santosh","Rohan@abc",125L)
			);
	
	@Override
	public List<Contacts> getContacts(Long userId) {
		
		 List<Contacts> contacts = list.stream().filter(c->c.getUserID().equals(userId)).collect(Collectors.toList());
		 return contacts;
	}

}
