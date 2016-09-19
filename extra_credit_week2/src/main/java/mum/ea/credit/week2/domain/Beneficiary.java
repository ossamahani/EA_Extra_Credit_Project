package mum.ea.credit.week2.domain;

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
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public PersonalInfo getInfo() {
		return info;
	}
	public void setInfo(PersonalInfo info) {
		this.info = info;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}

}
