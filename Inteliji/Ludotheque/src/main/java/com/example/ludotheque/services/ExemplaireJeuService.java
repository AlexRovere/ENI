package com.example.ludotheque.services;

import com.example.ludotheque.bo.ExemplaireJeu;
import com.example.ludotheque.dal.IExemplaireJeuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExemplaireJeuService implements IExemplaireJeuService {

    private final IExemplaireJeuRepository exemplaireJeuRepository;

    public ExemplaireJeuService(IExemplaireJeuRepository exemplaireJeuRepository) {
        this.exemplaireJeuRepository = exemplaireJeuRepository;
    }

    @Override
    public void add(ExemplaireJeu exemplaireJeu) {
        exemplaireJeuRepository.add(exemplaireJeu);
    }

    @Override
    public List<ExemplaireJeu> getAll() {
        return exemplaireJeuRepository.getAll();
    }

    @Override
    public Optional<ExemplaireJeu> getById(int id) {
        return exemplaireJeuRepository.getById(id);
    }

    public void update(ExemplaireJeu exemplaireJeu) {
        exemplaireJeuRepository.update(exemplaireJeu);
    }

    public void delete(int id) {
        exemplaireJeuRepository.delete(id);
    }
}
