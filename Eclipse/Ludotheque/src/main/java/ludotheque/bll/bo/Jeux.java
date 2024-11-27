package ludotheque.bll.bo;

import java.util.ArrayList;
import java.util.List;

public class Jeux {
	private String code;
	private String titre;
	private int reference;
	private int ageMinimum;
	private String description;
	private int dureeMoyenne;
	private float tarif;
	private Boolean louable;
	private List<GenreJeux> genres = new ArrayList<>();
	
	public Jeux(String code, String titre, int reference, int ageMinimum, String description, int dureeMoyenne,
			float tarif, Boolean louable, List<GenreJeux> genres) {
		super();
		this.code = code;
		this.titre = titre;
		this.reference = reference;
		this.ageMinimum = ageMinimum;
		this.description = description;
		this.dureeMoyenne = dureeMoyenne;
		this.tarif = tarif;
		this.louable = louable;
		this.genres = genres;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
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

	public int getAgeMinimum() {
		return ageMinimum;
	}

	public void setAgeMinimum(int ageMinimum) {
		this.ageMinimum = ageMinimum;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDureeMoyenne() {
		return dureeMoyenne;
	}

	public void setDureeMoyenne(int dureeMoyenne) {
		this.dureeMoyenne = dureeMoyenne;
	}

	public float getTarif() {
		return tarif;
	}

	public void setTarif(float tarif) {
		this.tarif = tarif;
	}

	public Boolean getLouable() {
		return louable;
	}

	public void setLouable(Boolean louable) {
		this.louable = louable;
	}

	public List<GenreJeux> getGenres() {
		return genres;
	}

	public void setGenres(List<GenreJeux> genres) {
		this.genres = genres;
	}
	
	
	
	
	
}
