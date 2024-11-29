package com.example.ludotheque.dal;

import com.example.ludotheque.bo.GenreJeu;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class GenreJeuRepository implements IGenreJeuRepository {

    private static int idxGenreJeu = 0;
    private List<GenreJeu> genreJeux;

    public GenreJeuRepository() {
        genreJeux = new ArrayList<>();
        GenreJeu gj1 = new GenreJeu( "stratégie");
        GenreJeu gj2 = new GenreJeu( "réflexion");
        add(gj1);
        add(gj2);
    }

    @Override
    public void add(GenreJeu genreJeu) {
        idxGenreJeu++;
        genreJeu.setId(idxGenreJeu);
        this.genreJeux.add(genreJeu);
    }

    @Override
    public List<GenreJeu> getAll() {
        return this.genreJeux;
    }

    @Override
    public  Optional<GenreJeu> getById(int id) {
        return this.genreJeux.stream().filter(c ->  c.getId() == id).findFirst();
    }

    public void update(GenreJeu genreJeu) {
        Optional<GenreJeu> oldGenreJeuOptional = getById(genreJeu.getId());
        if (oldGenreJeuOptional.isPresent()) {
            GenreJeu oldGenreJeu = oldGenreJeuOptional.get();
            oldGenreJeu.setLibelle(genreJeu.getLibelle());
        }
    }

    public void delete(int id) {
        Optional<GenreJeu> genreJeuOptional = getById(id);
        if (genreJeuOptional.isPresent()) {
            GenreJeu genreJeu = genreJeuOptional.get();
            genreJeux.remove(genreJeu);
        }
    }
}
