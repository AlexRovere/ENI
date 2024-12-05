package com.example.ludotheque.services;

import com.example.ludotheque.bo.Genre;
import com.example.ludotheque.dal.IGenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService implements IGenreService {

    private final IGenreRepository genreRepository;

    public GenreService(IGenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void add(Genre genre) {
    genreRepository.add(genre);
    }

    @Override
    public List<Genre> getAll() {
        return genreRepository.getAll();
    }

    @Override
    public Optional<Genre> getById(int id) {
        return genreRepository.getById(id);
    }

    @Override
    public void update(Genre genre) {
        genreRepository.update(genre);

    }

    @Override
    public void delete(int id) {
        genreRepository.delete(id);
    }
}
