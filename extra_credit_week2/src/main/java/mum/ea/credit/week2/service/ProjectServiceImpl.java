package mum.ea.credit.week2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mum.ea.credit.week2.dao.ProjectDAO;
import mum.ea.credit.week2.domain.Project;
import mum.ea.credit.week2.domain.Status;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDAO projectDAO;
	
	public List<Project> findAll() {
		return projectDAO.findAll();
	}

	public List<Project> findByStatus(Status status) {
		return projectDAO.findByStatus(status);
	}

	public List<Project> findByTasksSkillsName(String taskName) {
		return projectDAO.findByTasksSkillsName(taskName);
	}
	public List<Project> findByDescriptionLikeAndLocation(String keyword, String location){
		return projectDAO.findByDescriptionContainingAndLocationContaining(keyword, location);
	}

	public List<Project> findByTasksVolunteersOrderByTasksStartDate() {
		return projectDAO.findByTasksVolunteersOrderByTasksStartDate();
	}

	public Project addNew(Project project) {
		return projectDAO.save(project);
	}

	public void remove(Integer id) {
		 projectDAO.delete(id);
	}

	public Project get(Integer id) {
		return projectDAO.findOne(id);
	}

	public Project update(Project project) {
		return projectDAO.save(project);
	}
	
}
