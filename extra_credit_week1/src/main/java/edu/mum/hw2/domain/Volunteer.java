package edu.mum.hw2.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Volunteer {
	@Id @GeneratedValue
	private int id;
	@OneToOne
	@JoinColumn(name="info_id")
	private PersonalInfo info;
	@ManyToMany(mappedBy="volunteers", cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	private List<Task> Tasks = new ArrayList<Task>();
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
	public List<Task> getTasks() {
		return Tasks;
	}
	public void setTasks(List<Task> tasks) {
		Tasks = tasks;
	}

}
