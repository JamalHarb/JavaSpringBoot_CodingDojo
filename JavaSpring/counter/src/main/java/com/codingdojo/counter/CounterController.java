package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	@RequestMapping("")
	public String index(HttpSession session) {
		
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			int counter = (int) session.getAttribute("count");
			counter++;
			session.setAttribute("count", counter);
		}

		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		model.addAttribute("counter", session.getAttribute("count"));
		return "counter.jsp";
	}
}
