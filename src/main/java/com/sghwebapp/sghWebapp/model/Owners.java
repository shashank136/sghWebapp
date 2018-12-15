package com.sghwebapp.sghWebapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Owners {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String firstName;
	private String lastName;
	private String spouseName;
	private long number;
	private int size;
	private boolean welfareFeeStatus;
	private boolean associationMember;
	private String address;
	
	public Owners() {}
	
	public Owners(String firstName, String lastName, String spouseName, long number, int size, boolean welfareFeeStatus,
			boolean associationMember, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.spouseName = spouseName;
		this.number = number;
		this.size = size;
		this.welfareFeeStatus = welfareFeeStatus;
		this.associationMember = associationMember;
		this.address = address;
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

	public String getSpouseName() {
		return spouseName;
	}

	public void setSpouseName(String spouseName) {
		this.spouseName = spouseName;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isWelfareFeeStatus() {
		return welfareFeeStatus;
	}

	public void setWelfareFeeStatus(boolean welfareFeeStatus) {
		this.welfareFeeStatus = welfareFeeStatus;
	}

	public boolean isAssociationMember() {
		return associationMember;
	}

	public void setAssociationMember(boolean associationMember) {
		this.associationMember = associationMember;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
}
