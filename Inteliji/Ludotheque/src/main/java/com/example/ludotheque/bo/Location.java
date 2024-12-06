package com.example.ludotheque.bo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Location {
    private int noLocation;
    private LocalDate dateDebutLocation;
    private Boolean paye;
    private float prixTotal;
    private Client client;
    private List<DetailLocation> details = new ArrayList<>();

    public Location(LocalDate dateDebutLocation, Boolean paye, float prixTotal, Client client, List<DetailLocation> details) {
        this.dateDebutLocation = dateDebutLocation;
        this.paye = paye;
        this.prixTotal = prixTotal;
        this.client = client;
        this.details = details;
    }

    public Location(LocalDate dateDebutLocation, Boolean paye, float prixTotal, Client client) {
        this.dateDebutLocation = dateDebutLocation;
        this.paye = paye;
        this.prixTotal = prixTotal;
        this.client = client;
    }

    public Location() {
        super();
    }

    @Override
    public String toString() {
        return "Location{" +
                "noLocation=" + noLocation +
                ", dateDebutLocation=" + dateDebutLocation +
                ", paye=" + paye +
                ", prixTotal=" + prixTotal +
                ", client=" + client +
                ", details=" + details +
                '}';
    }

    public int getNoLocation() {
        return noLocation;
    }

    public void setNoLocation(int noLocation) {
        this.noLocation = noLocation;
    }

    public LocalDate getDateDebutLocation() {
        return dateDebutLocation;
    }

    public void setDateDebutLocation(LocalDate dateDebutLocation) {
        this.dateDebutLocation = dateDebutLocation;
    }

    public Boolean getPaye() {
        return paye;
    }

    public void setPaye(Boolean paye) {
        this.paye = paye;
    }

    public float getPrixTotal() {
        return this.prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<DetailLocation> getDetails() {
        return details;
    }

    public void setDetails(List<DetailLocation> details) {
        this.details = details;
    }

    public void setDetail(DetailLocation detail) {
        this.details.add(detail);
    }

}
