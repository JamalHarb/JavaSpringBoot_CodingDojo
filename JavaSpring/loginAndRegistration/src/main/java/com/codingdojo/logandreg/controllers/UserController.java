package com.codingdojo.logandreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.logandreg.models.LoginUser;
import com.codingdojo.logandreg.models.User;
import com.codingdojo.logandreg.services.UserService;

@Controller
public class UserController {
	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("")
	public String index(
			@ModelAttribute("newUser") User newUser,
			@ModelAttribute("newLogin") LoginUser loginUser) {
        return "index.jsp";
    }
	
	@PostMapping("/register")
	public String register(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model model,
			HttpSession session) {
		userService.register(newUser, result);
		if(result.hasErrors()) { 
            model.addAttribute("newLogin", new LoginUser()); 
            return "index.jsp";
        }
		session.setAttribute("user", newUser);
		return "redirect:/home";
	}
	
	@PostMapping("/login")
    public String login(
    		@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result,
            Model model,
            HttpSession session) {
        User user = userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
        session.setAttribute("user", user);
        return "redirect:/home";
    }
	
	@GetMapping("/home")
    public String home(HttpSession session) {
        if (session.getAttribute("user") != null) {
        return "home.jsp";
        }
        else {
            return "redirect:/";
        }
    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) { 
	    session.invalidate();
	    return "redirect:/";
    }
}
