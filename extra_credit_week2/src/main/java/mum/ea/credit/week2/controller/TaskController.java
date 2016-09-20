package mum.ea.credit.week2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.ea.credit.week2.domain.Task;
import mum.ea.credit.week2.service.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	

	@RequestMapping(value="/tasks", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("tasks", taskService.findAll());
		return "taskList";
	}
	
	@RequestMapping(value="/tasks", method=RequestMethod.POST)
	public String add(Task task) {
		taskService.addNew(task);
		return "redirect:/tasks";
	}

	@RequestMapping(value="/tasks/{id}", method=RequestMethod.GET)
	public String get(@PathVariable int id, Model model) {
		model.addAttribute("task", taskService.get(id));
		return "taskDetail";
	}
	
	@RequestMapping(value="/tasks/{id}", method=RequestMethod.POST)
	public String update(Task task, @PathVariable int id) {
		taskService.update(task);
		return "redirect:/tasks";
	}
	
	@RequestMapping(value="/tasks/delete", method=RequestMethod.POST)
	public String delete(int taskId) {
		taskService.remove(taskId);
		return "redirect:/tasks";
	}


	@ExceptionHandler(value=NoSuchResourceException.class)
	public ModelAndView handle(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.getModel().put("e", e);
		mv.setViewName("noSuchResource");
		return mv;
	}

}
