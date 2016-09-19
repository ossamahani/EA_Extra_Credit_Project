package mum.ea.credit.week2.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Admin{
	@Id @GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name="info_id")
	private PersonalInfo info;
	@OneToMany(mappedBy = "admin")
    private List<Project> projects = new ArrayList<Project>();
	
	public Admin(int id, PersonalInfo info)
	{
		this.id = id;
		this.info = info;
	}
	
	public Admin()
	{
		
	}
	
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
	public List<Project> getProjects() {
		return Collections.unmodifiableList(projects);
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	public void addProject(Project project) {
		projects.add(project);
		project.setAdmin(this);
	}
	
	public void removeProject(Project project) {
		project.setAdmin(null);
		projects.remove(project);
	}

}
