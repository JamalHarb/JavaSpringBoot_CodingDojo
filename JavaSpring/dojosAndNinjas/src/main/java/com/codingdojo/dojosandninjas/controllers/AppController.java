package com.codingdojo.dojosandninjas.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.dojosandninjas.models.Dojo;
import com.codingdojo.dojosandninjas.models.Ninja;
import com.codingdojo.dojosandninjas.services.AppService;

@Controller
public class AppController {
	private final AppService appService;
	public AppController(AppService appService) {
		this.appService = appService;
	}
	@RequestMapping("/dojos/new")
	public String dojoForm(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo_form.jsp";
	}
	@PostMapping("/dojos/create")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		appService.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	@RequestMapping("/ninjas/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		model.addAttribute("dojos", appService.allDojos());
		return "ninja_form.jsp";
	}
	@PostMapping("/ninjas/create")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja) {
		appService.createNinja(ninja);
		return "redirect:/ninjas/new";
	}
	@RequestMapping("/dojos/{id}")
	public String displayDojo(Model model, @PathVariable("id") Long id) {
		model.addAttribute("dojo", appService.findDojo(id));
		return "display_dojo.jsp";
	}
}
