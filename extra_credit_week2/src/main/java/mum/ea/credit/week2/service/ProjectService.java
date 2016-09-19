package mum.ea.credit.week2.service;

import java.util.List;

import mum.ea.credit.week2.domain.Project;
import mum.ea.credit.week2.domain.Status;

public interface ProjectService {
	
	List<Project> findAll();
	List<Project> findByStatus(Status status);
	List<Project> findByTasksSkillsName(String taskName);
	List<Project> findByDescriptionLikeAndLocation(String keyword, String location);
	List<Project> findByTasksVolunteersOrderByTasksStartDate();

}
