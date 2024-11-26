package fr.eni.demoSpringBeans.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eni.demoSpringBeans.bll.BonjourService;

@Controller
public class PremierController {
	
//	@Autowired
//	@Qualifier("HelloService")
//	private BonjourService bonjourService;
	
	private BonjourService bonjourService;

	
	public PremierController(BonjourService bonjourService) {
		this.bonjourService = bonjourService;
	}
	
	@GetMapping("/")
	public String home() {
		System.out.println(bonjourService.direBonjour());
		return "page/index";
	}
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println(bonjourService.direBonjour());
		return "page/hello";
	}
	
	@PostMapping("/hello2")
	public String hello2() {
		return "page/hello2";
	}
	
}
