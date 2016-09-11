package edu.mum.hw2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PersonalInfo{

	@Id @GeneratedValue
	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;

}
