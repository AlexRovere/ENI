package app;

import java.util.ArrayList;
import java.util.List;

import bo.Card.Costs;
import bo.Card.EColors;
import bo.Card.Formats;
import bo.Card.Planeswalkers;
import bo.Card.PlaneswalkersSkills;

public class Main {

	public static void main(String[] args) {
		
		// RED
		Costs cost1R = new Costs(EColors.RED, 1);
		Costs cost2R = new Costs(EColors.RED, 2);

		// BLACK
		Costs cost1B = new Costs(EColors.BLACK, 1);
		Costs cost2B = new Costs(EColors.BLACK, 2);
		
		// COLORLESS
		Costs cost1C = new Costs(EColors.COLORLESS, 1);
		Costs cost2C = new Costs(EColors.COLORLESS, 2);
		Costs cost3C = new Costs(EColors.COLORLESS, 3);
		Costs cost4C = new Costs(EColors.COLORLESS, 4);
		
		// FORMATS 
		Formats formatStandard = new Formats("Standard");
		Formats formatCommander = new Formats("Commander");


		
		// LILIANA OF THE VOID
		List<Costs> lilianaCosts = new ArrayList<Costs>();
		lilianaCosts.add(cost2B);
		lilianaCosts.add(cost4C);
		
		List<Formats> lilianaformats = new ArrayList<Formats>();
		lilianaformats.add(formatStandard);
		
		Planeswalkers liliana = new Planeswalkers("Liliana of the void", "De retour d'entre les morts", "M21", lilianaCosts, lilianaformats, 5);
				
		PlaneswalkersSkills lilinaFirstSKill = new PlaneswalkersSkills(liliana, 1, "Each player discard a card");
		PlaneswalkersSkills lilinaSecondSKill = new PlaneswalkersSkills(liliana, -3, "Each opponent sacrifice a creature");
		PlaneswalkersSkills lilinaThirdSKill = new PlaneswalkersSkills(liliana, -7, "You win the game");
		
		System.out.println(liliana);
		
		
		// SHANDRA AWAKENED INFERNO
		List<Costs> shandraCosts = new ArrayList<Costs>();
		shandraCosts.add(cost2R);
		shandraCosts.add(cost4C);
		
		List<Formats> shandraFormats = new ArrayList<Formats>();
		shandraFormats.add(formatStandard);
		
		Planeswalkers shandra = new Planeswalkers("Shandra awakened infero", "Elle embrasera le monde", "M22", shandraCosts, shandraFormats, 6);
		
		PlaneswalkersSkills shandraFirstSkill = new PlaneswalkersSkills(shandra, 2, "Each opponent gets an emblem : at the begening"
				+ "of your upkeep, this emblem deals 1 damage to you");
		PlaneswalkersSkills shandraSecondSkill = new PlaneswalkersSkills(shandra, -3, "deals 3 damage to each non-elemental creature");
		PlaneswalkersSkills shandraThirdSkill = new PlaneswalkersSkills(shandra, -7, "deals 7 damage to any target");
				
		System.out.println(shandra);

	}

}
