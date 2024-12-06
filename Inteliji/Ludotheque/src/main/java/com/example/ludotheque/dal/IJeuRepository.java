package com.example.ludotheque.dal;

import com.example.ludotheque.bo.Client;
import com.example.ludotheque.bo.Jeu;

import java.util.List;

public interface IJeuRepository extends ICrudRepository<Jeu> {
    List<Jeu> getAllWithFilters(String filter);

}
