package com.example.ludotheque.bo;

public class GenreJeu {

 private int id;
 private String libelle;

  public GenreJeu(String libelle) {
            this.libelle = libelle;
        }

    public GenreJeu() {
      super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
