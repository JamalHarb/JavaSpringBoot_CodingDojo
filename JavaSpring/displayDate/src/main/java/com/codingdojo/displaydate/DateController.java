package com.codingdojo.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date date = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("EEEEE, 'the' dd 'of' MMMMM, yyyy");
		String stringDate = DateFor.format(date);
		model.addAttribute("date", stringDate);
		return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date date = new Date();
		SimpleDateFormat TimeFor = new SimpleDateFormat("h:m a");
		String stringTime = TimeFor.format(date);
		model.addAttribute("time", stringTime);
		return "time.jsp";
	}
}
