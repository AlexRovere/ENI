package app;

import java.util.ArrayList;
import java.util.List;

import bo.Card.Costs;
import bo.Card.EColors;
import bo.Card.Formats;
import bo.Card.Planeswalkers;

public class Main {

	public static void main(String[] args) {
		
		Costs costBlack = new Costs(EColors.BLACK, 2);
		Costs costColorless = new Costs(EColors.COLORLESS, 4);
	
		List<Costs> costs = new ArrayList<Costs>();
		
		costs.add(costBlack);
		costs.add(costColorless);
		
		Formats format = new Formats("Standard");
		
		List<Formats> formats = new ArrayList<Formats>();
		
		formats.add(format);
		
		

		
		Planeswalkers liliana = new Planeswalkers("Liliana of the void", "De retour d'entre les morts", "M21", costs, formats, 5);
		
		System.out.println(liliana);
	}

}
