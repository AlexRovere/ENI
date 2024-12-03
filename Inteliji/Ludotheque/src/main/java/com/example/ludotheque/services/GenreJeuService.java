package com.example.ludotheque.services;

import com.example.ludotheque.bo.GenreJeu;
import com.example.ludotheque.dal.IGenreJeuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreJeuService implements IGenreJeuService {

    private final IGenreJeuRepository genreJeuRepository;

    public GenreJeuService(IGenreJeuRepository genreJeuRepository) {
        this.genreJeuRepository = genreJeuRepository;
    }


    @Override
    public void add(GenreJeu genreJeu) {
    genreJeuRepository.add(genreJeu);
    }

    @Override
    public List<GenreJeu> getAll() {
        System.out.println(genreJeuRepository.getAll().getFirst().getNoGenre());
        return genreJeuRepository.getAll();
    }

    @Override
    public Optional<GenreJeu> getById(int id) {
        return genreJeuRepository.getById(id);
    }

    @Override
    public void update(GenreJeu genreJeu) {
        genreJeuRepository.update(genreJeu);

    }

    @Override
    public void delete(int id) {
        genreJeuRepository.delete(id);
    }
}
