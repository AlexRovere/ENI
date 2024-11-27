package com.example.ludotheque.bll.bo;

import java.time.LocalDate;

public class Locations {
	private int id;
	private int client_id;
	private int jeux_id;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private float prix;
	private String statut;
	private int relanceClient;
	private int relanceMagasin;
	
	public Locations(int id, int client_id, int jeux_id, LocalDate dateDebut, LocalDate dateFin, float prix,
			String statut, int relanceClient, int relanceMagasin) {
		super();
		this.id = id;
		this.client_id = client_id;
		this.jeux_id = jeux_id;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.prix = prix;
		this.statut = statut;
		this.relanceClient = relanceClient;
		this.relanceMagasin = relanceMagasin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getJeux_id() {
		return jeux_id;
	}

	public void setJeux_id(int jeux_id) {
		this.jeux_id = jeux_id;
	}

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public int getRelanceClient() {
		return relanceClient;
	}

	public void setRelanceClient(int relanceClient) {
		this.relanceClient = relanceClient;
	}

	public int getRelanceMagasin() {
		return relanceMagasin;
	}

	public void setRelanceMagasin(int relanceMagasin) {
		this.relanceMagasin = relanceMagasin;
	}
	
	
}
