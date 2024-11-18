package fr.eni.quelmedecin.bo;

import java.time.LocalDate;
import java.util.Comparator;

import fr.eni.quelmedecin.bo.MedecinSpecialiste;

public class MedecinComparator implements Comparator<MedecinSpecialiste> {

	@Override
	public int compare(MedecinSpecialiste o1, MedecinSpecialiste o2) {
		int result = o1.getSpecialite().compareTo(o2.getSpecialite());
		return result;
	}
	
	LocalDate test = LocalDate

}
