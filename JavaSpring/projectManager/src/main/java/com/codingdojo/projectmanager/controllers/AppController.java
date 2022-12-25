package com.codingdojo.projectmanager.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.projectmanager.models.LoginUser;
import com.codingdojo.projectmanager.models.Project;
import com.codingdojo.projectmanager.models.User;
import com.codingdojo.projectmanager.services.ProjectService;
import com.codingdojo.projectmanager.services.UserService;

@Controller
public class AppController {
	private final UserService userService;
	private final ProjectService projectService;
	public AppController(UserService userService, ProjectService projectService) {
		this.projectService = projectService;
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
		return "redirect:/dashboard";
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
        return "redirect:/dashboard";
    }
	
	@GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {
        if (session.getAttribute("user") != null) {
        	User leader = (User) session.getAttribute("user");
        	User member = (User) session.getAttribute("user");
//        	User user = (User) session.getAttribute("user");
//        	Long leaderId = user.getId();
//        	Long memberId = user.getId();
        	model.addAttribute("otherProjects", projectService.otherProjects(leader, member));
        	model.addAttribute("myProjects", projectService.myProjects(leader, member));
	        return "dashboard.jsp";
        }
        else {
            return "redirect:/";
        }
    }
	
	@GetMapping("/projects/new")
	public String newProject(@ModelAttribute("project") Project project, HttpSession session) {
		if (session.getAttribute("user") != null) {
	        return "new_project.jsp";
        }
        else {
            return "redirect:/";
        }
	}
	
	@PostMapping("/projects/create")
	public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result) {
		System.out.println(result);
		if(result.hasErrors()) {
			 return "new_project.jsp";
		}
		projectService.create(project, result);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/{id}/join")
	public String joinProject(@PathVariable("id") Long id, HttpSession session) {
		User member = (User) session.getAttribute("user");
		Project project = projectService.findProject(id);
		project.getMembers().add(member);
		projectService.update(project);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/{id}/leave")
	public String leaveProject(@PathVariable("id") Long id, HttpSession session) {
		User member = (User) session.getAttribute("user");
		System.out.println("logged user" + member.getEmail());
		Project project = projectService.findProject(id);
		List<User> members = project.getMembers();
		System.out.println("members before removal");
		for(User user: members) {
			System.out.println(user.getEmail());
		}
		for(int i=0; i<members.size(); i++) {
			if(members.get(i).getEmail().equals(member.getEmail())) {
				members.remove(i);
				break;
			}
		}
		System.out.println("members after removal");
		for(User user: members) {
			System.out.println(user.getEmail());
		}
		project.setMembers(members);
		projectService.update(project);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/{id}/edit")
	public String edit(
			@PathVariable("id") Long id,
			@ModelAttribute("project") Project project,
			Model model) {
		model.addAttribute("project", projectService.findProject(id));
		return "edit.jsp";
	}
	
	@PostMapping("/projects/{id}/update")
	public String update(
			@PathVariable("id") Long id,
			@Valid @ModelAttribute("project") Project project,
			BindingResult result) {
		System.out.println(result);
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		projectService.update(project);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/{id}/show")
	public String showProject(Model model, @PathVariable("id") Long id) {
		model.addAttribute("project", projectService.findProject(id));
		return "show_project.jsp";
	}
	
	@GetMapping("/logout")
    public String logout(HttpSession session) { 
	    session.invalidate();
	    return "redirect:/";
    }
}
