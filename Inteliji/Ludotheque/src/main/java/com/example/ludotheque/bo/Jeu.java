package com.example.ludotheque.bo;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	private int id;
	private String titre;
	private int reference;
	private int ageMin;
	private String description;
	private int dureeMoyenne;
	private float tarifJournee;
	private List<GenreJeu> genres = new ArrayList<>();


	public Jeu(String titre, int reference, int ageMin, String description, int dureeMoyenne, float tarifJournee, List<GenreJeu> genres) {
		this.titre = titre;
		this.reference = reference;
		this.ageMin = ageMin;
		this.description = description;
		this.dureeMoyenne = dureeMoyenne;
		this.tarifJournee = tarifJournee;
		this.genres = genres;
	}

	public Jeu(String titre, int reference, int ageMin, String description, int dureeMoyenne, float tarifJournee) {
		this.titre = titre;
		this.reference = reference;
		this.ageMin = ageMin;
		this.description = description;
		this.dureeMoyenne = dureeMoyenne;
		this.tarifJournee = tarifJournee;
	}

	public Jeu() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getReference() {
		return reference;
	}

	public void setReference(int reference) {
		this.reference = reference;
	}

	public int getAgeMin() {
		return ageMin;
	}

	public void setAgeMin(int ageMin) {
		this.ageMin = ageMin;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDureeMoyenne() {
		return dureeMoyenne;
	}

	public void setDureeMoyenne(int dureeMoyenne) {
		this.dureeMoyenne = dureeMoyenne;
	}

	public float getTarifJournee() {
		return tarifJournee;
	}

	public void setTarifJournee(float tarifJournee) {
		this.tarifJournee = tarifJournee;
	}

	public List<GenreJeu> getGenres() {
		return genres;
	}

	public void setGenres(List<GenreJeu> genres) {
		this.genres = genres;
	}
}
