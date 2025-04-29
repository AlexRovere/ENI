package fr.eni.springApi.dal;

import fr.eni.springApi.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
