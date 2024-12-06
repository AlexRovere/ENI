package com.example.ludotheque.bo;

import java.time.LocalDate;

public class DetailLocation {
    private int noLigne;
    private LocalDate dateRetour;
    private float tarifLocation;
    private Jeu jeu;
    private Location location;

    public DetailLocation(int noLigne, float tarifLocation, Jeu jeu, Location location) {
        this.noLigne = noLigne;
        this.tarifLocation = tarifLocation;
        this.jeu = jeu;
        this.location = location;
    }

    public DetailLocation(Location location) {
        this.location = location;
    }

    public DetailLocation() {

    }

    @Override
    public String toString() {
        return "DetailLocation{" +
                "noLigne=" + noLigne +
                ", dateRetour=" + dateRetour +
                ", tarifLocation=" + tarifLocation +
                ", jeu=" + jeu +
                '}';
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public void setJeu(Jeu jeu) {
        this.jeu = jeu;
    }

    public float getTarifLocation() {
        return tarifLocation;
    }

    public void setTarifLocation(float tarifLocation) {
        this.tarifLocation = tarifLocation;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public int getNoLigne() {
        return noLigne;
    }

    public void setNoLigne(int noLigne) {
        this.noLigne = noLigne;
    }
}
