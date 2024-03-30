package com.microservices.contactmicroservice;

import java.util.List;

public interface ContactService {
	
	public List<Contacts> getContacts(Long userId);

}
