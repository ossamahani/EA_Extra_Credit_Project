package mum.ea.credit.week2.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import mum.ea.credit.week2.domain.Project;
import mum.ea.credit.week2.domain.Status;

public interface ProjectDAO extends JpaRepository<Project, Serializable> , CrudRepository<Project, Serializable>{

	List<Project> findAll(); 
	List<Project> findByStatus(Status status);
	List<Project> findByTasksSkillsName(String taskName);
	List<Project> findByDescriptionContainingAndLocationContaining(String keyword, String location);
	List<Project> findByTasksVolunteersOrderByTasksStartDate();
	
}
