package fr.eni.demoSpringJdbc;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import fr.eni.demoSpringJdbc.bo.Pizza;
import fr.eni.demoSpringJdbc.dal.PizzaRepositoryImpl;

@SpringBootTest
class DemoSpringJdbcApplicationTests {

	
	@Autowired
	private PizzaRepositoryImpl pizzaRepository;
	
	@Test
	void testPizzaRepoFindAllCasDroit() {
		
		
		//Appel de la méthode à tester
		List<Pizza> pizzas = pizzaRepository.findAllPizzas();
		
		//Afficher les pizzas sur la console
		pizzas.forEach(p->System.out.println(p));

		//Vérifier que des pizzas ont été lues en BD
		Assert.notEmpty(pizzas, "La liste des pizzas ne devrait pas être vide");
	}

	
	// @Test
	void testPizzaRepoFindByIdCasDroit() {
	
		//Appel de la méthode à tester
		Optional<Pizza>  optPizza = pizzaRepository.findPizzaById(1);
		
		//Vérifier que des pizzas ont été lues en BD
		Assert.isTrue(optPizza.isPresent(), "La pizza 1 aurait du être trouvée !");
		
		if(optPizza.isPresent()) {
			System.out.println(optPizza.get());
		}
	}
	
	// @Test
	void testPizzaRepoInsertPizzaCasDroit() {
		//AAA : Arrange Act Assert
		//Arrange
		Pizza pizza = new Pizza(4, "Reine", 12.3f);
		
		//Act : Appel de la méthode à tester
		pizzaRepository.insertPizza(pizza);
		
		//Assert : 
		Optional<Pizza>  optPizza = pizzaRepository.findPizzaById(4);
		Assert.isTrue(optPizza.isPresent(), "La pizza 4 aurait du être crée !");
		
		if(optPizza.isPresent()) {
			System.out.println("Test insert - pizza = " +optPizza.get());
		}
	}

}









