package nombreMystere.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nombreMystere.services.PartieService;

@Controller
public class HomeController {
	
	
	PartieService partieService;
	
	HomeController(PartieService partieService) {
		this.partieService = partieService;
	}
	
	@GetMapping
	public String home(@RequestParam(required = false, value = "reset") String reset) {
		if(reset != null) partieService.restartGame();
		return "index";
	}
	
	@PostMapping
	public String home(@RequestParam("userNumber") int userNumber, Model model) {
		partieService.play(userNumber);

		model.addAttribute("resultat", partieService.getResultat());
		model.addAttribute("userNumber", partieService.getUserNumber());
		model.addAttribute("computerNumber", partieService.getComputerNumber());
		model.addAttribute("tryLeft", partieService.getTryLeft());
		model.addAttribute("helper", partieService.getHelper());
		model.addAttribute("userWin", partieService.getUserWin());

		return "index";
	}
}
