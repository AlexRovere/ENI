package module2TP3;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	static String europeanDatePattern = "dd/MM/yyyy";
	static DateTimeFormatter format = DateTimeFormatter.ofPattern(europeanDatePattern);

	public static void main(String[] args) {

		String currentDate = displayDate("01/10/2024");

		Scanner s = new Scanner(System.in);

		String input = "";

		while (input != "exit") {

			System.out.println(
					"Commande disponible : \n - 'r' Rechercher une date format('DD/MM/YYYY') \n - 'n' pour le mois suivant \n - 'p' pour le mois précédant \n - 'c' pour quitter le programme");

			input = s.nextLine();

			if (input.equals("c"))
				break;

			if (input.equals("n")) {
				LocalDate date = LocalDate.parse(currentDate, format).plusMonths(1);
				String stringDate = date.format(format);
				currentDate = displayDate(stringDate);
			}

			if (input.equals("p")) {
				LocalDate date = LocalDate.parse(currentDate, format).minusMonths(1);
				String stringDate = date.format(format);
				currentDate = displayDate(stringDate);
			}

			if (input.equals("r")) {
				System.out.println("Veuillez renseigner la date");
				input = s.nextLine();
				currentDate = displayDate(input);
			}

		}

		s.close();

	};

	public static String displayDate(String input) {
		String regex = "^([0-2][0-9]||3[0-1])/(0[0-9]||1[0-2])/([0-9][0-9])?[0-9][0-9]$";

		LocalDateTime date;

		if (input.matches(regex)) {
			LocalDate lDate = LocalDate.parse(input, format);
			date = lDate.atStartOfDay();
		} else {
			System.out.println(
					"Désolé la date que vous avez renré n'est pas correct, la date du jour est affiché par défaut");
			date = LocalDateTime.now();

		}

		LocalDateTime firstDayOfMonth = date.with(TemporalAdjusters.firstDayOfMonth());
		int lastDayOfMonth = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
		int firstDay = firstDayOfMonth.getDayOfWeek().getValue();

		String[][] calendarArr = { { "L" }, { "MA" }, { "ME" }, { "J" }, { "V" }, { "S" }, { "D" } };

		ArrayList<String> simpleList = new ArrayList<String>();

		// ajout de case vide avant le premier jour du mois
		for (int i = 1; i < firstDay; i++) {
			simpleList.add("  ");
		}

		int index = firstDay;

		for (int i = 0; i < lastDayOfMonth; i++) {
			if (index == 7)
				index = 0;
			String day = String.valueOf(i + 1);
			if (day.length() < 2)
				day = "0" + day;
			simpleList.add(day);
			index++;
		}

		// Afficher l'heure
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm:ss");
		System.out.println("        " + formatTime.format(LocalDateTime.now()));

		// Affiche mois et année
		DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("MMMM", Locale.FRANCE);
		System.out.println("      " + date.format(monthFormatter).toUpperCase() + "  " + date.getYear());

		// Affiche les jours
		for (String[] day : calendarArr) {
			if (day[0].length() == 2)
				System.out.print(day[0] + "  ");
			else
				System.out.print(day[0] + "   ");
		}

		System.out.println();

		int idxDay = 1;

		for (String day : simpleList) {
			if (idxDay == 7) {
				idxDay = 0;
				System.out.println(day);
			} else {
				System.out.print(day + "  ");
			}
			idxDay++;
		}
		System.out.println();
		String lastDate = date.format(format);
		return lastDate;
	};

}
