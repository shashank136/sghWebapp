package com.shgWebApp.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="renters")
public class Renters implements Serializable{
	
	private static final long serialVersionUID = 4L; 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
    @Column(name = "firstname")
    private String firstname;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "contact")
    private String contact;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "familysize")
    private String familysize;
    
    @Column(name = "ownername")
    private String ownername;

	public Renters() {}

	public Renters(String firstname, String lastname, String contact, String address, String familysize,
			String ownername) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.contact = contact;
		this.address = address;
		this.familysize = familysize;
		this.ownername = ownername;
	}

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

	public String getFamilysize() {
		return familysize;
	}

	public void setFamilysize(String familysize) {
		this.familysize = familysize;
	}

	public String getOwnername() {
		return ownername;
	}

	public void setOwnername(String ownername) {
		this.ownername = ownername;
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
		Renters other = (Renters) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Renters [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", contact=" + contact
				+ ", address=" + address + ", familysize=" + familysize + ", ownername=" + ownername + "]";
	}

}
