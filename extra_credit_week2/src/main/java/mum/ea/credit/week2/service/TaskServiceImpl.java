package mum.ea.credit.week2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import mum.ea.credit.week2.dao.TaskDAO;
import mum.ea.credit.week2.domain.Project;
import mum.ea.credit.week2.domain.Task;

public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskDAO taskDAO;
	
	public List<Task> findByProjct(Project project) {
		return taskDAO.findByProject(project);
	}

	public Task addNew(Task task) {
		return taskDAO.save(task);
	}

	public void remove(Integer id) {
		taskDAO.delete(id);
	}

	public Task get(Integer id) {
		return taskDAO.findOne(id);
	}

	public Task update(Task task) {
		return taskDAO.save(task);
	}

	public List<Task> findAll() {
		return taskDAO.findAll();
	}

}
