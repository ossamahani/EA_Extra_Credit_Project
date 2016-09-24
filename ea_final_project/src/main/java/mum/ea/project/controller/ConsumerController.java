package mum.ea.project.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.ea.project.domain.Consumer;
import mum.ea.project.service.ConsumerService;

@Controller
public class ConsumerController {
	
	@Autowired
	private ConsumerService consumerService;
	
	
	@RequestMapping("/")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/consumer/login")
	public String login() {
		return "login";
	}
	
	
	@RequestMapping("/consumer/register")
	public String register(Model model) {		
		model.addAttribute("consumer", new Consumer());
		return "registerConsumer";
	}
	
	
	@RequestMapping(value="/consumer/register", method=RequestMethod.POST)
	public String register(Consumer consumer, Model model,HttpSession session) {		
		consumerService.register(consumer);
		session.setAttribute("consumer", consumer);
		//model.addAllAttributes("items", )
		return "consumerDashboard";
	}
	
	
	
	
}
