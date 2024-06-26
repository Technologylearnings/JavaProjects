package com.microservices.usermicroservice;

import java.util.ArrayList;
import java.util.List;

public class User {
	
	private Long userId;
	private String userName;
	private List<Contacts> contacts=new ArrayList<>();
	
	public User() {
		
	}
	
	public User(Long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Contacts> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contacts> contacts) {
		this.contacts = contacts;
	} 
	
	

}
