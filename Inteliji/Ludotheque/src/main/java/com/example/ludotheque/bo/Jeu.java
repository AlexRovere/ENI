package com.example.ludotheque.bo;

import java.util.ArrayList;
import java.util.List;

public class Jeu {
	private int noJeu;
	private String titre;
	private int reference;
	private int ageMin;
	private String description;
	private int duree;
	private float tarifJournee;
	private List<GenreJeu> genres = new ArrayList<>();

	public Jeu(String titre, int reference, int ageMin, String description, int duree, float tarifJournee, List<GenreJeu> genres) {
		this.titre = titre;
		this.reference = reference;
		this.ageMin = ageMin;
		this.description = description;
		this.duree = duree;
		this.tarifJournee = tarifJournee;
		this.genres = genres;
	}

	public Jeu(String titre, int reference, int ageMin, String description, int duree, float tarifJournee) {
		this.titre = titre;
		this.reference = reference;
		this.ageMin = ageMin;
		this.description = description;
		this.duree = duree;
		this.tarifJournee = tarifJournee;
	}

	@Override
	public String toString() {
		return "Jeu{" +
				"noJeu=" + noJeu +
				", titre='" + titre + '\'' +
				", reference=" + reference +
				", ageMin=" + ageMin +
				", description='" + description + '\'' +
				", duree=" + duree +
				", tarifJournee=" + tarifJournee +
				", genres=" + genres +
				'}';
	}

	public Jeu() {
		super();
	}

	public int getNoJeu() {
		return noJeu;
	}

	public void setNoJeu(int noJeu) {
		this.noJeu = noJeu;
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

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
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
