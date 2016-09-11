package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project {
	
	@Id @GeneratedValue
	private int id;
	private String name;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Enumerated(EnumType.STRING)
	private Status status;
	private String location;
	@OneToMany(mappedBy = "project")
	private List<Task> tasks = new ArrayList<Task>();
	@OneToMany(mappedBy = "project")
	private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();	
}
