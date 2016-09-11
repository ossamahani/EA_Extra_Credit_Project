package edu.mum.hw2.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Beneficiary {
	@Id @GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name="info_id")
	private PersonalInfo info;
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;

}
