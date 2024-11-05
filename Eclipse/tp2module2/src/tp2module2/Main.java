package tp2module2;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.ZonedDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		ZonedDateTime date = ZonedDateTime.now();
		
		System.out.println(date);
		
		   String[][] calendarArr = {
		            {"L"},  
		            {"MA"}, 
		            {"ME"},
		            {"J"},
		            {"V"},
		            {"S"},
		            {"D"}
		        };
		   
		   ArrayList<ArrayList<String>> calendarList = new ArrayList<>(
		            Arrays.asList(
		                    new ArrayList<>(Arrays.asList("L")),
		                    new ArrayList<>(Arrays.asList("MA")),
		                    new ArrayList<>(Arrays.asList("ME")),
		                    new ArrayList<>(Arrays.asList("J")),
		                    new ArrayList<>(Arrays.asList("V")),
		                    new ArrayList<>(Arrays.asList("S")),
		                    new ArrayList<>(Arrays.asList("D"))
		                )
		            );

		   
		   Month m = date.getMonth();
		   int year = date.getYear();
		   
	        ZonedDateTime firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
	        int firstDayIntOfMonth = date.with(TemporalAdjusters.firstDayOfMonth()).getDayOfMonth();
	        int lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
	        int firstDay = firstDayOfMonth.getDayOfWeek().getValue();

		   
		   // on chope l'index du premier jour
		   // on incremente l'index a chaque nouveau jour
		   // on repart à 0 après 7
		   // on s'arrête quand il n'y a plus de jour
		   
		   
		   for (int i = 0; i < firstDay; i++) {
			   calendarList.get(i).add(" ");
			   System.out.println(i);
		   }
		   
		   System.out.println(calendarList.get(0));

		   		   
		   for(int i = 0; i < lastDayOfMonth; i++) {
			  // System.out.println(i);
		   }

	
	for (String[] day : calendarArr) {
		System.out.print(day[0] + "   ");
	}

};
}
