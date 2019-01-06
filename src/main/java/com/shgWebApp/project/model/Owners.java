package com.shgWebApp.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="owners")
public class Owners implements Serializable{
	
	private static final long serialVersionUID = 4L; 

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
    @Column(name = "firstname")
    private String firstname;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "spousename")
    private String spousename;
    
    @Column(name = "contact")
    private String contact;
    
    @Column(name = "address")
    private String address;
    
    @Column(name = "familysize")
    private String familysize;
    
    @Column(name = "welfarefeestatus")
    private String welfarefeestatus;  

	public Owners() {}

	public Owners(String firstname, String lastname, String spousename, String contact, String address,
			String familysize, String welfarefeestatus) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.spousename = spousename;
		this.contact = contact;
		this.address = address;
		this.familysize = familysize;
		this.welfarefeestatus = welfarefeestatus;
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
	public String getFamilysize() {
		return familysize;
	}

	public void setFamilysize(String familysize) {
		this.familysize = familysize;
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

	public String getWelfarefeestatus() {
		return welfarefeestatus;
	}

	public void setWelfarefeestatus(String welfarefeestatus) {
		this.welfarefeestatus = welfarefeestatus;
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
		return "Owners [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", spousename=" + spousename
				+ ", contact=" + contact + ", address=" + address + ", familysize=" + familysize + ", welfarefeestatus="
				+ welfarefeestatus + "]";
	}
}
