package edu.mum.hw2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.Project;
import edu.mum.hw2.domain.Status;

public class ProjectDAO {
	
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	
	
	public void addProjct(Project project) 
	{	
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			em.persist(project);
			tx.commit();
		} 
		catch (Throwable e)
		{
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		
	}
	
	public List<Project> getProjectsAndBeneficiariesInfo()
	{
		List<Project> projects = null;
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			projects = em.createNamedQuery("getProjectsInformation", Project.class).getResultList();
			tx.commit();
		} 
		catch (Throwable e)
		{
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		return projects;
	}
	
	public List<Project> getProjectsByStatus(Status status)
	{
		List<Project> projects = null;
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			projects = em.createNamedQuery("getProjectsByStatus", Project.class).setParameter("status", status).getResultList();
			tx.commit();
		} 
		catch (Throwable e)
		{
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		return projects;
	}
	
	public List<Project> getProjectsBySkill(String skillName)
	{
		List<Project> projects = null;
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			projects = em.createNamedQuery("getProjectsBySkill", Project.class).setParameter("skill", skillName).getResultList();
			tx.commit();
		} 
		catch (Throwable e)
		{
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		return projects;
	}
	
	public List<Project> getProjectsByKeyword(String keyword)
	{
		List<Project> projects = null;
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			projects = em.createNamedQuery("getProjectsByKeyword", Project.class).setParameter("keyword", "%"+keyword+"%").getResultList();
			tx.commit();
		} 
		catch (Throwable e)
		{
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		return projects;
		
	}
	
	public List<Project> getProjectsInfoHaveVolunteer()
	{
		List<Project> projects = null;
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			projects = em.createNamedQuery("getProjectsInfoHaveVolunteer", Project.class).getResultList();
			tx.commit();
		} 
		catch (Throwable e)
		{
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		return projects;
	}
	
}
