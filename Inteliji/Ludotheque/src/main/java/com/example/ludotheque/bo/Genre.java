package com.example.ludotheque.bo;

import java.util.Objects;

public class Genre {

 private int noGenre;
 private String libelle;

    public Genre(String libelle, int noGenre) {
        this.noGenre = noGenre;
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "noGenre=" + noGenre +
                ", libelle='" + libelle + '\'' +
                '}';
    }

    public Genre(String libelle) {
            this.libelle = libelle;
        }

    public Genre() {
      super();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return noGenre == genre.noGenre && Objects.equals(libelle, genre.libelle);
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
