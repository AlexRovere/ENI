package com.example.ludotheque.dal;

import com.example.ludotheque.bo.Client;
import com.example.ludotheque.bo.Jeu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class JeuRepository implements IJeuRepository {

    private static int idxJeu = 0;
    private List<Jeu> jeux;

    public JeuRepository() {
        jeux = new ArrayList<>();

        jeux = new ArrayList<>();
        Jeu j1 = new Jeu("HeroQuest", 15616131, 18, "un jeu d'aventure !", 120, 5 );
        Jeu j2 = new Jeu("Monopoly", 156161656, 6, "un jeu de société !", 60, 3 );
        add(j1);
        add(j2);
    }

    @Override
    public void add(Jeu jeu) {
        idxJeu++;
        jeu.setId(idxJeu);
        this.jeux.add(jeu);
    }

    @Override
    public List<Jeu> getAll() {
        return this.jeux;
    }

    @Override
    public  Optional<Jeu> getById(int id) {
        return this.jeux.stream().filter(c ->  c.getId() == id).findFirst();
    }

    public void update(Jeu jeu) {
        Optional<Jeu> oldJeuOptional = getById(jeu.getId());
        if (oldJeuOptional.isPresent()) {
            Jeu oldJeu = oldJeuOptional.get();
            oldJeu.setTitre(jeu.getTitre());
            oldJeu.setReference(jeu.getReference());
            oldJeu.setDescription(jeu.getDescription());
            oldJeu.setDureeMoyenne(jeu.getDureeMoyenne());
        }
    }

    public void delete(int id) {
        Optional<Jeu> jeuOptional = getById(id);
        if (jeuOptional.isPresent()) {
            Jeu jeu = jeuOptional.get();
           jeux.remove(jeu);
        }
    }
}
