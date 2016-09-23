package mum.ea.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mum.ea.project.service.ProviderService;

@Controller
@RequestMapping(value="/provider")
public class ProviderController {

	@Autowired
	private ProviderService providerService;
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("provider", providerService.getAllProviders());
		return "providerList";
	}
	
	
	
	
	
}
