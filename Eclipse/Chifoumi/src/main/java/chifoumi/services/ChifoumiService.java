package chifoumi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class ChifoumiService implements IChifoumi {
	List<String> values = new ArrayList<>(List.of("chi", "fou", "mi"));

	
	public String getComputerValue() {
		Random random = new Random();
		int randomIdx = random.nextInt(2 + 1);
		String computerValue = values.get(randomIdx);
		return computerValue;
	}
	
	public String getWinner(String userValue) {
		String computerValue = this.getComputerValue();
		System.out.println("COMPUTER VALUE = " + computerValue + "\n" + "USER VALUE = " + userValue);
		if(computerValue.equals(userValue)) {
			return "draw";
		}
		if(computerValue.equals("chi") && userValue.equals("fou") || computerValue.equals("fou") && userValue.equals("mi")
				|| computerValue.equals("mi") && userValue.equals("chi")) {
			return "user";
		}
		
		return "computer";
		
	}
}
