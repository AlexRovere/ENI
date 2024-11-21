package data;
import java.io.Serializable;
import java.util.List;

import bo.Utilisateur;

public record Utilisateurs(List<Utilisateur> utilisateurs) implements Serializable {

}

