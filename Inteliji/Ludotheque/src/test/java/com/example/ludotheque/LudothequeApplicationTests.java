package com.example.ludotheque;

import com.example.ludotheque.bo.Client;
import com.example.ludotheque.dal.ClientRepositoryJdbcImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class LudothequeApplicationTests {

    @Autowired
    private ClientRepositoryJdbcImpl clientImpl;

    @Test
    void contextLoads() {
    }

    @Test
    void testClientRepoFindAll() {
        List<Client> clients = clientImpl.getAll();

        clients.forEach(c->System.out.println(c.toString()));
    }

    @Test
    void testClientRepoInsert() {
        // AAA : Arrange Act Assert

        // Arrange
        Client client = new Client("nom", "prenom",  "email", "adresse");

        // Act
        clientImpl.add(client);

        // Assert
        Optional<Client> optClient = clientImpl.findById(1);
        Assert.isTrue(optClient.isPresent(), "Le client 1 aurait du être crée !");

        if(optClient.isPresent()) {

        }
    }





}
