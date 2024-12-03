package fr.eni.demoSpringJdbc.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.demoSpringJdbc.bo.Pizza;

public interface PizzaRepository {
	List<Pizza> findAllPizzas();
	
	Optional<Pizza> findPizzaById(int id);
	
	void insertPizza(Pizza pizza);
	
}
