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
	private String number;
	private int size; // family size
	private boolean welfareFeeStatus;
	private boolean associationMember;
	private String address;
	
	public Owners() {}
	
	public Owners(String firstName, String lastName, String spouseName, String number, int size, boolean welfareFeeStatus,
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Owners other = (Owners) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Owners [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", spouseName=" + spouseName
				+ ", number=" + number + ", size=" + size + ", welfareFeeStatus=" + welfareFeeStatus
				+ ", associationMember=" + associationMember + ", address=" + address + "]";
	}
	
}
