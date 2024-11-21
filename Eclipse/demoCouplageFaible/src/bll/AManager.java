package bll;

import bo.Personne;
import dal.DAOBuilder;
import dal.DAOInterface;

public class AManager {
	private DAOInterface dao;
	
	AManager() {
		dao = DAOBuilder.createInstance();
	}
	
	public void persister(Personne p) {
		dao.sauvegarder(p);
	}
}
