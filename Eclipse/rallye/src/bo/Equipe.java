package bo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Equipe  {
	String nom;
	Boolean constructeur;
	Nationalite nationalite;
	static int equipageIndex = 0;
	List<Equipage> equipages = new ArrayList<>(3);
	
	
	public Equipe(String nom, Nationalite nationalite, Boolean constructeur) {
		this.nom = nom;
		this.constructeur = constructeur;
		this.nationalite = nationalite;
		equipageIndex++;
	}


	public static Equipe getEquipe(String nom, Nationalite nationalite, Boolean constructeur) {
		Equipe equipe = new Equipe(nom, nationalite, constructeur);
		equipageIndex++;
		return equipe;
	}
	
	public void ajouterEquipage(Equipage equipage) throws ProgrammeurException {
		if(equipage == null) throw new ProgrammeurException("L'instance équipage doit être renseigné");
		equipages.add(equipage);
	}

	public String infosEquipe() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equipe [nom=");
		builder.append(nom);
		builder.append(", constructeur=");
		builder.append(constructeur);
		builder.append(", equipageIndex=");
		builder.append(equipageIndex);
		for(Equipage equipage : equipages ) {
			builder.append(", equipages=");
			builder.append(equipage.infosEquipage());
			builder.append("]");
		}
	
		return builder.toString();
	}
	
	public Optional<Equipage> getEquipage(int dossard) {
		return equipages.stream().filter(e -> e.getDossard() == dossard).findFirst();
	}
	
	
}
