package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHumanController {
	@RequestMapping("")
	public String hello(@RequestParam(value="name", required=false) String firstName, @RequestParam(value="last_name", required=false) String lastName, @RequestParam(value="times", required=false) Integer times) {
		if(firstName == null) {
			return "Hello Human";			
		}
		else if(lastName == null) {
			if(times == null) {
				return "Hello " + firstName;				
			}
			else {
				return String.format("Hello %s ", firstName).repeat(times);
			}
		}
		else {
			if(times == null) {
				return "Hello " + firstName + " " + lastName;
			}
			else {
				return String.format("Hello %s %s ", firstName, lastName).repeat(times);
			}
		}
	}
	
}
