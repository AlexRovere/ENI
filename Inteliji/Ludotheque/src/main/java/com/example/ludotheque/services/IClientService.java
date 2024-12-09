package com.example.ludotheque.services;

import com.example.ludotheque.Exception.EmailAlreadyTakenException;
import com.example.ludotheque.bo.Client;
import com.example.ludotheque.bo.Jeu;

import java.util.List;

public interface IClientService extends ICrudService <Client>{
    List<Client> getAllWithFilters(String filter);
    void isClientEmailTaken(String email) throws EmailAlreadyTakenException;
}
