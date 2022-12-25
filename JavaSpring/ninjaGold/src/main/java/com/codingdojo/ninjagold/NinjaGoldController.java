package com.codingdojo.ninjagold;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NinjaGoldController {
	private ArrayList<String> log = new ArrayList<String>();
	@RequestMapping("")
	public String form(HttpSession session) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activity") == null) {
			session.setAttribute("activity", new ArrayList<String>());
		}
		if(session.getAttribute("time") == null) {
			session.setAttribute("time", "");
		}
		return "form.jsp";
	}
	@PostMapping("/process_gold")
	public String gold(HttpSession session, @RequestParam(value="which_place") String place) {
		session.setAttribute("time", new Date());
		Random random = new Random();
		if(place.equals("quest")) {
			int rand = random.nextInt(101) - 50;
			int gold = (int) session.getAttribute("gold");
			gold = gold + rand;
			session.setAttribute("gold", gold);
			if(rand > 0) {
				log.add(0, String.format("You completed a quest and earned %s gold. (%s)", rand, session.getAttribute("time")));
				session.setAttribute("activity", log);
			}
			else if(rand < 0) {
				log.add(0, String.format("You failed a quest and lost %s gold. Ouch. (%s)", rand, session.getAttribute("time")));
				session.setAttribute("activity", log);
			}
			else {
				log.add(0, String.format("The quest didn't yield any gold. (%s)", session.getAttribute("time")));
				session.setAttribute("activity", log);
			}
		}
		else {
			int rand = random.nextInt(11) + 10;
			int gold = (int) session.getAttribute("gold");
			gold = gold + rand;
			session.setAttribute("gold", gold);
			if(place.equals("farm")) {
				log.add(0, String.format("You enterd a farm and earned %s gold. (%s)", rand, session.getAttribute("time")));
				session.setAttribute("activity", log);
			}
			else if(place.equals("cave")) {
				log.add(0, String.format("You enterd a cave and earned %s gold. (%s)", rand, session.getAttribute("time")));
				session.setAttribute("activity", log);
			}
			else {
				log.add(0, String.format("You enterd a house and earned %s gold. (%s)", rand, session.getAttribute("time")));
				session.setAttribute("activity", log);
			}
		}
		return "redirect:/";
	}
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		log = new ArrayList<String>();
		session.invalidate();
		return "redirect:/";
	}
}
