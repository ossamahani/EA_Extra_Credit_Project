package mum.ea.credit.week2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.credit.week2.domain.Project;
import mum.ea.credit.week2.service.ProjectService;

@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@RequestMapping("/")
	public String redirectRoot() {
		return "redirect:/projects";
	}
	
	@RequestMapping(value="/projects", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("projects", projectService.findAll());
		return "projectList";
	}
	
	@RequestMapping(value="/projects", method=RequestMethod.POST)
	public String add(Project project) {
		projectService.addNew(project);
		return "redirect:/projects";
	}

	@RequestMapping(value="/projects/{id}", method=RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("project", projectService.get(id));
		return "projectDetail";
	}
	
	@RequestMapping(value="/projects/{id}", method=RequestMethod.POST)
	public String update(Project project, @PathVariable int id) {
		projectService.update(project);
		return "redirect:/projects";
	}
	
	@RequestMapping(value="/projects/delete", method=RequestMethod.POST)
	public String delete(int projectId) {
		projectService.remove(projectId);
		return "redirect:/projects";
	}


	@ExceptionHandler(value=NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}

	public ProjectService getProjectService() {
		return projectService;
	}

	public void setProjectService(ProjectService projectService) {
		this.projectService = projectService;
	}
}
