package com.example.ludotheque.bo;

import java.util.ArrayList;
import java.util.List;

public class Magasin {
	private int id;
	private String nom;
	private String adresse;
	private String telephone;
	private List<Jeu> jeux = new ArrayList<>();
	
	public Magasin(int id, String nom, String adresse, String telephone, List<Jeu> jeux) {
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

	public List<Jeu> getJeux() {
		return jeux;
	}

	public void setJeux(List<Jeu> jeux) {
		this.jeux = jeux;
	}
	
	
}
