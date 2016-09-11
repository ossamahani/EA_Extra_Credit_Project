package edu.mum.hw2.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Task {
	@Id @GeneratedValue
	private int id;
	private String name;
	private String description;
	@Temporal(TemporalType.TIMESTAMP)
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	@Enumerated(EnumType.STRING)
	private Status status;
	@ManyToOne
	@JoinColumn(name="project_id")
	private Project project;
	@ManyToOne
	@JoinColumn(name="volunteer_id")
	private Volunteer volunteer;

}
