package com.example.ludotheque.services;

import com.example.ludotheque.bo.ExemplaireJeu;
import com.example.ludotheque.bo.Jeu;
import com.example.ludotheque.dal.IJeuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JeuService implements IJeuService {

    private final IJeuRepository jeuRepository;

    public JeuService(IJeuRepository jeuRepository) {
        this.jeuRepository = jeuRepository;
    }

    @Override
    public void add(Jeu client) {
        jeuRepository.add(client);
    }

    @Override
    public List<Jeu> getAll() {
        return jeuRepository.getAll();
    }

    @Override
    public Optional<Jeu> getById(int id) {
        return jeuRepository.getById(id);
    }

    public void update(Jeu client) {
        jeuRepository.update(client);
    }

    public void delete(int id) {
        jeuRepository.delete(id);
    }

    public long getQuantityOfExemplaireAvaible(Jeu jeu) {
      return  jeu.getExemplaires().stream().filter(ExemplaireJeu::getLouable).count();
    };

    @Override
    public List<Jeu> getAllWithFilters(String filter) {
        return jeuRepository.getAllWithFilters(filter);
    }

}
