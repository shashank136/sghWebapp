package com.sghwebapp.sghWebapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Worker {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private long contact;
	private String adhaarCard;
	
	public Worker(){}
	
	public Worker(String firstName, String lastName, long contact, String adhaarCard) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.adhaarCard = adhaarCard;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getAdhaarCard() {
		return adhaarCard;
	}

	public void setAdhaarCard(String adhaarCard) {
		this.adhaarCard = adhaarCard;
	}	

}
