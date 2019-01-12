package com.shgWebApp.project.commands;

public class OwnersForm {

	private long id;
	private String firstname;
	private String lastname;
	private String spousename;
	private String contact;
	private String address;
	private String familysize;
	private String welfarefeestatus;
	
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
	public String getSpousename() {
		return spousename;
	}
	public void setSpousename(String spousename) {
		this.spousename = spousename;
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
	public String getFamilysize() {
		return familysize;
	}
	public void setFamilysize(String familysize) {
		this.familysize = familysize;
	}
	public String getWelfarefeestatus() {
		return welfarefeestatus;
	}
	public void setWelfarefeestatus(String welfarefeestatus) {
		this.welfarefeestatus = welfarefeestatus;
	}
}
