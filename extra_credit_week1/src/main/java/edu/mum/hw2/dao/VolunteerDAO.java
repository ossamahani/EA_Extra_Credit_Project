package edu.mum.hw2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import edu.mum.hw2.domain.PersonalInfo;
import edu.mum.hw2.domain.Volunteer;

public class VolunteerDAO {
	private static EntityManagerFactory emf;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("cs544");
		} catch (Throwable ex) {
			ex.printStackTrace();
			throw new ExceptionInInitializerError(ex);
		}
	}

	
	
	public void addVolunteer(Volunteer volunteer, PersonalInfo info) 
	{	
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try
		{
			tx.begin();
			
			em.persist(info);
			volunteer.setInfo(info);
			em.persist(volunteer);
			
			tx.commit();
		} 
		catch (Throwable e)
		{
			if ((tx != null) && (tx.isActive())) tx.rollback();
		} finally {
			if ((em != null) && (em.isOpen())) em.close();
		}
		
	}


}
