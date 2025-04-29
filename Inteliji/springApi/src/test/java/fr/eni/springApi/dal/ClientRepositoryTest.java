package fr.eni.springApi.dal;

import fr.eni.springApi.bo.Client;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ClientRepositoryTest  {

    @Autowired
    private ClientRepository clientRepository;

    @Test
    @DisplayName("Test de création d'un client - cas positif")
    @Transactional
    public void testCreationClient() {
        Client client = new Client();
        client.setName("smith");
        client.setFirstname("bob");
        client.setAge(10);
        client.setPhone("0645659878");

        Client clientDb = clientRepository.save(client);
        
        assertThat(clientDb).isNotNull();
    }
}
