package fr.eni.ludotheque.bo;

public class ExemplaireJeu {
    private int noExemplaireJeu;
    private int noJeu;
    private String codebarre;
    private Boolean louable;

    public ExemplaireJeu(int noJeu, String codebarre, Boolean louable) {
        this.noJeu = noJeu;
        this.codebarre = codebarre;
        this.louable = louable;
    }

    public ExemplaireJeu(int noJeu) {
       this();
    	this.noJeu = noJeu;
    }

    public ExemplaireJeu() {
       super();
       this.louable = false;
    }

    @Override
    public String toString() {
        return "ExemplaireJeu{" +
                "noExemplaire=" + noExemplaireJeu +
                ", noJeu=" + noJeu +
                ", codebarre='" + codebarre + '\'' +
                ", louable=" + louable +
                '}';
    }

    public int getNoExemplaireJeu() {
        return noExemplaireJeu;
    }

    public void setNoExemplaireJeu(int noExemplaire) {
        this.noExemplaireJeu = noExemplaire;
    }

    public int getNoJeu() {
        return noJeu;
    }

    public void setNoJeu(int noJeu) {
        this.noJeu = noJeu;
    }

    public String getCodebarre() {
        return codebarre;
    }

    public void setCodebarre(String codebarre) {
        this.codebarre = codebarre;
    }

    public Boolean getLouable() {
        return louable;
    }

    public void setLouable(Boolean louable) {

        this.louable = louable==null?false:louable;
    }
}
