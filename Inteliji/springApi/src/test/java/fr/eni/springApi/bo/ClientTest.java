package fr.eni.springApi.bo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ClientTest {

    /*
    Test la création d'un client
     */
    @Test
    @DisplayName("Test de création d'un client - cas positif")
    public void testCreationClient() {
        // AAA
        // Arrange
        Client client = null;

        // Act
        client = new Client();
        client.setFirstname("bob");
        client.setName("smith");
        client.setAge(10);

        // Assert
        assertThat(client).isNotNull();
        assertThat(client.getFirstname()).isEqualTo("bob");
        assertThat(client.getName()).isEqualTo("smith");
    }

    /*
 Test la création d'un client avec le builder
  */
    @Test
    @DisplayName("Test de création d'un client - cas positif")
    public void testCreationClientBuilder() {
        // AAA
        // Arrange
        Client client = new Client();

        // Act
        client.setFirstname("bob");
        client.setName("smith");
        client.setAge(18);

        // Assert
        assertThat(client).isNotNull();
        assertThat(client.getFirstname()).isEqualTo("bob");
        assertThat(client.getName()).isEqualTo("smith");
    }
}
