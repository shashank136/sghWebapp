package com.shgWebApp.project.commands;

public class RentersForm {
	
	private long id;
	private String firstname;
	private String lastname;
	private String contact;
	private String address;
	private String ownername;
	private String familysize;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	public String getFamilysize() {
		return familysize;
	}
	public void setFamilysize(String familysize) {
		this.familysize = familysize;
	}	

}
