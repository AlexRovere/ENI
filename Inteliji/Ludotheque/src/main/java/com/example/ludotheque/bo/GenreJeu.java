package com.example.ludotheque.bo;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        GenreJeu genreJeu = (GenreJeu) o;
        return noGenre == genreJeu.noGenre && Objects.equals(libelle, genreJeu.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(noGenre, libelle);
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
