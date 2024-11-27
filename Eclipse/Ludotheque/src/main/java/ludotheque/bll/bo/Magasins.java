package ludotheque.bll.bo;

import java.util.ArrayList;
import java.util.List;

public class Magasins {
	private int id;
	private String nom;
	private String adresse;
	private String telephone;
	private List<Jeux> jeux = new ArrayList<>();
	
	public Magasins(int id, String nom, String adresse, String telephone, List<Jeux> jeux) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.jeux = jeux;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<Jeux> getJeux() {
		return jeux;
	}

	public void setJeux(List<Jeux> jeux) {
		this.jeux = jeux;
	}
	
	
}
