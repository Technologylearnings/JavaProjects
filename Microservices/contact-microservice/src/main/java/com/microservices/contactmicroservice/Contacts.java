package com.microservices.contactmicroservice;

public class Contacts {
	
	private int contactId;
	private String contactName;
	private String contactEmail;
	private Long userID;
	
	
	public Contacts() {
		
	}

	public Contacts(int contactId, String contactName, String contactEmail, Long userID) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.userID = userID;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactEmail() {
		return contactEmail;
	}

	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}
	
	
	

}
