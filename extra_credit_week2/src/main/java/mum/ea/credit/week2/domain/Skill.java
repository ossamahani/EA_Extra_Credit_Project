package mum.ea.credit.week2.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Skill {
	@Id @GeneratedValue
	private int id;
	private String name;
	@ManyToMany(mappedBy = "skills", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private List<Task> tasks = new ArrayList<Task>();
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
	public List<Task> getTasks() {
		return tasks;
	}
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

}
