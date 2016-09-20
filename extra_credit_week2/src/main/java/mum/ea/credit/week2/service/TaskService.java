package mum.ea.credit.week2.service;

import java.util.List;

import mum.ea.credit.week2.domain.Project;
import mum.ea.credit.week2.domain.Task;

public interface TaskService {
	
	List<Task> findAll();
	List<Task> findByProjct(Project project);
	Task addNew(Task task);
	void remove(Integer id);
	Task get(Integer id);
	Task update(Task project);

}
