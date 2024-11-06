package module2TP2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		
		LocalDate revolution = LocalDate.of(1789, Month.JULY, 14);
		System.out.println(revolution);
		
		LocalDate newRevolution = revolution;
		
		newRevolution = newRevolution.plusYears(10);
		newRevolution = newRevolution.plusMonths(4);
		newRevolution = newRevolution.plusDays(3);
		
		LocalDate armistice = LocalDate.of(1911, Month.NOVEMBER, 14);
		
		LocalDate dateNow = LocalDate.now();
		
		long nowEpoch = dateNow.toEpochDay();
		long revolutionEpoch = revolution.toEpochDay();
		long armisticeEpoch = armistice.toEpochDay();
				
		long diffRevolution = nowEpoch - revolutionEpoch;
		long diffArmistice = nowEpoch - armisticeEpoch;
		
		if(diffRevolution > diffArmistice) {
			System.out.println("Armistice est plus proche de la date du jour");
		} else {
			System.out.println("Revolution est plus proche de la date du jour");
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String formattedArmistice = armistice.format(formatter);
				
		System.out.println(formattedArmistice);




	}

}
