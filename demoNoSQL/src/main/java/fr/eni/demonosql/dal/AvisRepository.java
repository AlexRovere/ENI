package fr.eni.demonosql.dal;

import fr.eni.demonosql.bo.Avis;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AvisRepository extends MongoRepository<Avis, String> {
}
