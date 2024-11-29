package com.example.ludotheque.dal;

import com.example.ludotheque.bo.Client;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository implements IClientRepository {

    private static int idxClient = 0;
    private List<Client> clients;

    public ClientRepository() {
        clients = new ArrayList<>();
        Client c1 = new Client( "rovere", "alex");
        Client c2 = new Client( "dupond", "benois");
        add(c1);
        add(c2);
    }

    @Override
    public void add(Client client) {
        idxClient++;
        client.setId(idxClient);
        System.out.println(client);
        this.clients.add(client);
    }

    @Override
    public List<Client> getAll() {
        return this.clients;
    }

    @Override
    public  Optional<Client> getById(int id) {
        return this.clients.stream().filter(c ->  c.getId() == id).findFirst();
    }

    public void update(Client client) {
        Optional<Client> oldClientOptional = getById(client.getId());
        if (oldClientOptional.isPresent()) {
            Client oldClient = oldClientOptional.get();
            oldClient.setNom(client.getNom());
            oldClient.setPrenom(client.getPrenom());
            oldClient.setAdresse(client.getAdresse());
            oldClient.setEmail(client.getEmail());
        }
    }

    public void delete(int id) {
        Optional<Client> clientOptional = getById(id);
        if (clientOptional.isPresent()) {
            Client client = clientOptional.get();
           clients.remove(client);
        }
    }
}
