package edu.mum.hw2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Admin{
	@Id @GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name="info_id")
	private PersonalInfo info;

}
