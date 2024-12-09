package com.example.ludotheque.dal;

import com.example.ludotheque.Exception.EmailAlreadyTakenException;
import com.example.ludotheque.bo.Client;
import com.example.ludotheque.bo.Jeu;

import java.util.List;

public interface IClientRepository extends ICrudRepository<Client> {
    List<Client> getAllWithFilters(String filter);
    void isClientEmailTaken (String email) throws EmailAlreadyTakenException;
}
