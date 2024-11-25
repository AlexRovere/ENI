package fr.eni.demoPremiereAppli.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PremierController {
	
	
	@GetMapping("/hello")
	public String hello() {
		return "page/hello";
	}
	
	@PostMapping("/hello2")
	public String hello2() {
		return "page/hello2";
	}
	
}
