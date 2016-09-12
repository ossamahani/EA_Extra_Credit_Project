package edu.mum.hw2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import edu.mum.hw2.domain.Task;

public class TaskDAO {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public void addTask(Task task) 
	{	
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			em.persist(task);
			tx.commit();
		} 
		catch (Throwable e)
		{
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
	}
	
	public List<Task> getTasksByProject(int projectId)
	{
		List<Task> tasks = null;
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			tasks = em.createNamedQuery("getTasksByProject", Task.class).setParameter("projectId", projectId).getResultList();
			tx.commit();
		} 
		catch (Throwable e)
		{
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		return tasks;	
	}

}
