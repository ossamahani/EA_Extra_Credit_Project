package mum.ea.credit.week2.service;

import java.util.List;

import mum.ea.credit.week2.domain.Project;
import mum.ea.credit.week2.domain.Task;

public interface TaskService {
	
	List<Task> findByProjct(Project project);

}
