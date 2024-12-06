package com.example.ludotheque.services;

import com.example.ludotheque.bo.Jeu;

import java.util.List;

public interface IJeuService  extends ICrudService<Jeu>{
     List<Jeu> getAllWithFilters(String filter);
}
