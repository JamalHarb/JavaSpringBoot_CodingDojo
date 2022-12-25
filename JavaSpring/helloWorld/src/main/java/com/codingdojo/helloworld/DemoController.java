package com.codingdojo.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	@RequestMapping("/demo")
	public String index() {
		return "demo.jsp";
	}
	@RequestMapping("/fruit")
	public String fruit(Model model) {
		model.addAttribute("fruit", "banana");
		return "fruit.jsp";
	}
}
