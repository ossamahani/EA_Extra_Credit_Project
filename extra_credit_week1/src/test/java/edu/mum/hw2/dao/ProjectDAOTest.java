package edu.mum.hw2.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import edu.mum.hw2.domain.Beneficiary;
import edu.mum.hw2.domain.PersonalInfo;
import edu.mum.hw2.domain.Project;
import edu.mum.hw2.domain.Skill;
import edu.mum.hw2.domain.Status;
import edu.mum.hw2.domain.Task;
import edu.mum.hw2.domain.Volunteer;

public class ProjectDAOTest {
	
	private ProjectDAO projectDao;
	private Project project;
	@Before
	public void setUp() throws ParseException
	{

		projectDao = new ProjectDAO();
		
		SimpleDateFormat sfd = new SimpleDateFormat("yyyy-MM-dd");
		
		Skill skill = new Skill();
		skill.setName("Java");
		List<Skill> skills = new ArrayList<Skill>();
		skills.add(skill);
	
		Volunteer volunteer = new Volunteer();
		volunteer.setInfo(new PersonalInfo("Ossama Hani", "ossama.hani@hotmail.com"));
		List<Volunteer> volunteers = new ArrayList<Volunteer>();
		
		

		Task task = new Task();
		List<Task> tasks = new ArrayList<Task>();
		task.setDescription("First Task In Project");
		task.setStartDate(sfd.parse("2013-11-17"));
		task.setEndDate(sfd.parse("2013-12-17"));
		task.setStatus(Status.COMPLETED);
		
		tasks.add(task);
		
		skill.setTasks(tasks);
		task.setSkills(skills);
		volunteer.setTasks(tasks);
		volunteers.add(volunteer);
		task.setVolunteers(volunteers);
		
		
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setInfo(new PersonalInfo("John Smith", "john.smith@gmail.com"));
		List<Beneficiary> beneficiaries = new ArrayList<Beneficiary>();
		
		
		

		project = new Project();
		project.setDescription("Monitoring System");
		project.setStartDate(sfd.parse("2012-10-17"));
		project.setEndDate(sfd.parse("2013-10-17"));
		project.setStatus(Status.COMPLETED);
		
		project.setTasks(tasks);
		
		beneficiary.setProject(project);
		beneficiaries.add(beneficiary);
		project.setBeneficiaries(beneficiaries);
		
		
	}
	
	@Test
	public void addProject()
	{
		projectDao.addProjct(project);
	}
	
	@Test
	public void getProjectsAndBeneficiariesInfo()
	{
		List<Project> projects = projectDao.getProjectsAndBeneficiariesInfo();
		projects.forEach(project ->
		{
		   System.out.println("Project Description : "+project.getDescription());
		   
		   project.getBeneficiaries().forEach(beneficiary->
		   {
			   System.out.println("Beneficiary Name : "+ beneficiary.getInfo().getName());
			   System.out.println("Beneficiary Email : "+beneficiary.getInfo().getEmail());  
		   });
		});
		
	}
	
	

}
