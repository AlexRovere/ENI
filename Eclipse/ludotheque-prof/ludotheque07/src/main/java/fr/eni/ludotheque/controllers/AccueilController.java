package fr.eni.ludotheque.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class AccueilController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/")
	public String accueil(Model modele) {
		modele.addAttribute("body", "accueil");
		return "index";
	}

	@GetMapping("/chiffrer")
	public String chiffrer(@RequestParam("mot") String mot) {
		System.out.println("[" + passwordEncoder.encode(mot) + "]");
		return "redirect:/";
	}
}
