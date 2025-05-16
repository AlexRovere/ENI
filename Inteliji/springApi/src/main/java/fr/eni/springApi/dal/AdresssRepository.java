package fr.eni.springApi.dal;

import fr.eni.springApi.bo.Adress;
import fr.eni.springApi.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdresssRepository extends JpaRepository<Adress, Long> {
}
