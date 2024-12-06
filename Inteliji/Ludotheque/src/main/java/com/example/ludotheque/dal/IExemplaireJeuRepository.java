package com.example.ludotheque.dal;

import com.example.ludotheque.bo.ExemplaireJeu;
import com.example.ludotheque.bo.Genre;
import com.example.ludotheque.bo.Location;

public interface IExemplaireJeuRepository extends ICrudRepository<ExemplaireJeu> {
    void returnExemplaireToStore (int noJeu);
    void giveExemplaireToClient (int noJeu);
    void returnAllExemplaireToStoreFromLocation (Location location);
}
