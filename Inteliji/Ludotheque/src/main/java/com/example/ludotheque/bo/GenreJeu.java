package com.example.ludotheque.bo;

public class GenreJeu {

 private int noGenre;
 private String libelle;

    public GenreJeu(String libelle, int noGenre) {
        this.noGenre = noGenre;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "GenreJeu{" +
                "noGenre=" + noGenre +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    public GenreJeu(String libelle) {
            this.libelle = libelle;
        }

    public GenreJeu() {
      super();
    }

    public int getNoGenre() {
        return noGenre;
    }

    public void setNoGenre(int noGenre) {
        this.noGenre = noGenre;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
