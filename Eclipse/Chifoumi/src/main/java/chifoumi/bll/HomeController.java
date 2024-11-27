package chifoumi.bll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import chifoumi.service.ChifoumiService;
import chifoumi.service.IChifoumi;

@Controller
public class HomeController {

	IChifoumi chifoumiService;

	HomeController(IChifoumi chifoumiService) {
		this.chifoumiService = chifoumiService;
	}

	@GetMapping("/chifoumi")
	public String home() {
		return "page/chifoumi";
	}

	@RequestMapping("/jouer")
	public String jouer(@RequestParam("value") String userValue) {
		String winner = chifoumiService.getWinner(userValue);
		System.out.println(winner);
		if (winner.equals("user")) {
			return "page/winner";
		}
		if (winner.equals("computer")) {
			return "page/looser";
		}
		return "page/draw";
	}

}
