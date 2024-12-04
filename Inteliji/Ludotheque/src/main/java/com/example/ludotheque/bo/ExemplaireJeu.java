package com.example.ludotheque.bo;

public class ExemplaireJeu {
    private int noExemplaire;
    private int noJeu;
    private String codeBarre;
    private Boolean louable;

    public ExemplaireJeu(int noExemplaire, int noJeu, String codeBarre, Boolean louable) {
        this.noExemplaire = noExemplaire;
        this.noJeu = noJeu;
        this.codeBarre = codeBarre;
        this.louable = louable;
    }

    public ExemplaireJeu() {
       super();
    }

    @Override
    public String toString() {
        return "ExemplaireJeu{" +
                "noExemplaire=" + noExemplaire +
                ", noJeu=" + noJeu +
                ", codeBarre='" + codeBarre + '\'' +
                ", louable=" + louable +
                '}';
    }

    public int getNoExemplaire() {
        return noExemplaire;
    }

    public void setNoExemplaire(int noExemplaire) {
        this.noExemplaire = noExemplaire;
    }

    public int getNoJeu() {
        return noJeu;
    }

    public void setNoJeu(int noJeu) {
        this.noJeu = noJeu;
    }

    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public Boolean getLouable() {
        return louable;
    }

    public void setLouable(Boolean louable) {
        this.louable = louable;
    }
}
