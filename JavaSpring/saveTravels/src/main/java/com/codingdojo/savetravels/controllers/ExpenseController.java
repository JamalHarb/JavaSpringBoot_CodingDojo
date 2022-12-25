package com.codingdojo.savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.savetravels.models.Expense;
import com.codingdojo.savetravels.services.ExpenseService;

@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@RequestMapping("/expenses")
	public String index(Model model, @ModelAttribute("expense") Expense expense) {
		List<Expense> expenses = expenseService.findAll();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	@PostMapping("/expenses/add")
	public String addExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.findAll();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	@RequestMapping("/expenses/edit/{id}")
	public String edit(Model model, @ModelAttribute("expense") Expense expense, @PathVariable("id") Long id) {
		Expense expenseToEdit = expenseService.findExpense(id);
		model.addAttribute("expense", expenseToEdit);
		return "edit.jsp";
	}
	@PostMapping("/expenses/edit/{id}/update")
	public String update(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, Model model, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
//			Expense expenseToEdit = expenseService.findExpense(id);
//			model.addAttribute("expense", expenseToEdit);
			return "edit.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expenses";
	}
	@RequestMapping("/expenses/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	@RequestMapping("/expenses/view/{id}")
	public String view(Model model, @PathVariable("id") Long id) {
		Expense expense = expenseService.findExpense(id);
		model.addAttribute("expense", expense);
		return "view.jsp";
	}
}
