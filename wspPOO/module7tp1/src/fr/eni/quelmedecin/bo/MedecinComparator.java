package fr.eni.quelmedecin.bo;

import java.util.Comparator;

public class MedecinComparator implements Comparator<MedecinSpecialiste> {

	@Override
	public int compare(MedecinSpecialiste o1, MedecinSpecialiste o2) {
		int result = o1.getSpecialite().compareTo(o2.getSpecialite());
		return result;
	}
	
}
