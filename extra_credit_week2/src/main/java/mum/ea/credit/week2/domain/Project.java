package mum.ea.credit.week2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Project {
	
	@Id @GeneratedValue
	private int id;
	private String description;
	private String location;
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	@Enumerated(EnumType.STRING)
	private Status status;
	@OneToMany(mappedBy = "project", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private List<Task> tasks = new ArrayList<Task>();
	@OneToMany(mappedBy = "project", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();
	@ManyToOne
	@JoinColumn(name="admin_id")
	private Admin admin;
	
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
		return Collections.unmodifiableList(tasks);
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	public List<Beneficiary> getBeneficiaries() {
		return Collections.unmodifiableList(beneficiaries);
	}
	public void setBeneficiaries(List<Beneficiary> beneficiaries) {
		this.beneficiaries = beneficiaries;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}	
	
	public void addBeneficiary(Beneficiary beneficiary) {
		beneficiaries.add(beneficiary);
		beneficiary.setProject(this);
	}
	
	public void removeBeneficiary(Beneficiary beneficiary) {
		beneficiary.setProject(null);
		beneficiaries.remove(beneficiary);
	}
	
	public void addTask(Task task) {
		tasks.add(task);
		task.setProject(this);
	}
	
	public void removeTask(Task task) {
		task.setProject(null);
		tasks.remove(task);
	}
}
