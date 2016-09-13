package edu.mum.hw2.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PersonalInfo{

	@Id @GeneratedValue
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@OneToOne(mappedBy="info", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Beneficiary beneficiary;
	@OneToOne(mappedBy="info", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Volunteer volunteer;
	@OneToOne(mappedBy="info", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private Admin admin;
	
	
	private PersonalInfo()
	{
		
	}
	
	public PersonalInfo(String name, String email)
	{
		this.name = name;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Beneficiary getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary beneficiary) {
		this.beneficiary = beneficiary;
	}

	public Volunteer getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

}
