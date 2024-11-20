package app;

import java.util.ArrayList;
import java.util.List;

import bo.Card.Cards;
import bo.Card.Costs;
import bo.Card.EColors;
import bo.Card.Formats;
import bo.Card.Planeswalkers;
import bo.Card.PlaneswalkersSkills;
import bo.Card.Skills;

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
				
		PlaneswalkersSkills lilinaFirstSKill = new PlaneswalkersSkills(liliana, 1, "Each player discard a card");
		PlaneswalkersSkills lilinaSecondSKill = new PlaneswalkersSkills(liliana, -3, "Each opponent sacrifice a creature");
		PlaneswalkersSkills lilinaThirdSKill = new PlaneswalkersSkills(liliana, -7, "You win the game");
		
		System.out.println(liliana);

				
	}

}
