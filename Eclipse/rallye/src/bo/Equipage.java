package bo;

public class Equipage {
	int dossard;
	Concurrent pilote;
	Concurrent coPilote;
	
	public Equipage(int dossard, String nomPilote, String prenomPilote, Nationalite nationalitePilote,
			String nomCoPilote, String prenomCoPilote, Nationalite nationaliteCoPilote) {
		super();
		this.dossard = dossard;
		this.pilote = new Concurrent(nomPilote, prenomPilote, nationalitePilote);
		this.coPilote = new Concurrent(nomCoPilote, prenomCoPilote, nationaliteCoPilote);
	}
	
	public String infosEquipage() {
		StringBuilder builder = new StringBuilder();
		builder.append("Equipage [dossard=");
		builder.append(dossard);
		builder.append(", pilote=");
		builder.append(pilote.infosConcurrent());
		builder.append(", coPilote=");
		builder.append(coPilote.infosConcurrent());
		builder.append("]");
		return builder.toString();
	}

	public int getDossard () {
		return dossard;
	}
}
