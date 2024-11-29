package com.example.ludotheque.services;

import com.example.ludotheque.bo.Client;
import com.example.ludotheque.dal.IClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {

    private final IClientRepository clientRepository;

    public ClientService(IClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void add(Client client) {
        clientRepository.add(client);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.getAll();
    }

    @Override
    public Optional<Client> getById(int id) {
        return clientRepository.getById(id);
    }

    public void update(Client client) {
        clientRepository.update(client);
    }

    public void delete(int id) {
        clientRepository.delete(id);
    }
}
