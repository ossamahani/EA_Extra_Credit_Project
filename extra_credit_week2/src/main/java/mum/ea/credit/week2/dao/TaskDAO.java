package mum.ea.credit.week2.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import mum.ea.credit.week2.domain.Project;
import mum.ea.credit.week2.domain.Task;

public interface TaskDAO extends JpaRepository<Task, Serializable> , CrudRepository<Task, Serializable>
{
	
	List<Task> findByProjct(Project project);
	
}
