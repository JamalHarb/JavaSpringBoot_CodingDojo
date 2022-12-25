package com.codingdojo.languages.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService languageService;
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	@RequestMapping("/languages")
	public String index(Model model, @ModelAttribute("language") Language language) {
		model.addAttribute("languages", languageService.findAllLanguages());
		return "index.jsp";
	}
	@PostMapping("/languages/create")
	public String create(Model model, @Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			model.addAttribute("languages", languageService.findAllLanguages());
			return "index.jsp";
		}
		else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/languages/{id}/edit")
	public String edit(
			@PathVariable("id") Long id,
			@ModelAttribute("language") Language language,
			Model model) {
		model.addAttribute("language", languageService.findLanguage(id));
		return "edit.jsp";
	}
	@PostMapping("/languages/{id}/update")
	public String update(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("language") Language language,
			BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			languageService.updateLanguage(language);
			return "redirect:/languages";
		}
	}
	@RequestMapping("/languages/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		languageService.deleteLanguage(id);
		return "redirect:/languages";
	}
	@RequestMapping("/languages/{id}")
	public String display(@PathVariable("id") Long id, Model model) {
		model.addAttribute("language", languageService.findLanguage(id));
		return "display.jsp";
	}
}
