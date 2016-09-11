package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQueries({
	@NamedQuery(name="getProjectsInformation", query="SELECT DISTINCT P FROM Project P"),
	@NamedQuery(name="getProjectsByStatus", query="SELECT DISTINCT P FROM Project P WHERE P.status = :status"),
	@NamedQuery(name="getProjectsBySkill", query="SELECT DISTINCT P FROM Project P JOIN P.tasks T JOIN T.skills SK WHERE SK.name = :skill"),
	@NamedQuery(name="getProjectsByKeyword", query="SELECT DISTINCT P FROM Project P JOIN P.beneficiaries B V WHERE P.description LIKE %:keyword% or B.address LIKE %:keyword%"),
	@NamedQuery(name="getProjectsAndSKillsByVolunteer", query="SELECT DISTINCT P FROM Project P JOIN P.tasks T JOIN T.volunteers V ORDER BY T.startDate")	
})
public class Project {
	
	@Id @GeneratedValue
	private int id;
	private String description;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Enumerated(EnumType.STRING)
	private Status status;
	@OneToMany(mappedBy = "project")
	private List<Task> tasks = new ArrayList<Task>();
	@OneToMany(mappedBy = "project")
	private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<Beneficiary> getBeneficiaries() {
		return beneficiaries;
	}
	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}	
}
