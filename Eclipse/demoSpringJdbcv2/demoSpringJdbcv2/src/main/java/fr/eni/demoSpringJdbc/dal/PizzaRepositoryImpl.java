package fr.eni.demoSpringJdbc.dal;

import java.beans.BeanProperty;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.demoSpringJdbc.bo.Pizza;

@Repository
//@Component
public class PizzaRepositoryImpl implements PizzaRepository{

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private JdbcTemplate jdbcTemplate;

	public PizzaRepositoryImpl(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.jdbcTemplate = namedParameterJdbcTemplate.getJdbcTemplate();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}
	
	@Override
	public List<Pizza> findAllPizzas() {
		String sql = "select id, nom, prix from pizza";

		// V1 List<Pizza> pizzas = jdbcTemplate.query(sql, new PizzaRowMapper());
		List<Pizza> pizzas = namedParameterJdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Pizza.class));
		return pizzas;
	}

	@Override
	public Optional<Pizza> findPizzaById(int id) {
		String sql = "select id, nom, prix from pizza where id = ?";
		Pizza pizza = jdbcTemplate.queryForObject(sql, new PizzaRowMapper(), id);
		
		return Optional.ofNullable(pizza);
	}

	@Override
	public void insertPizza(Pizza pizza) {
		//String sql = "insert into pizza (id, nom, prix) values (?, ?, ?)";
		
		//Version 1
		//int nbRows = jdbcTemplate.update(sql, pizza.getId(), pizza.getNom(), pizza.getPrix());
		
		//Version 2
//		int nbRows = jdbcTemplate.update(sql, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement ps) throws SQLException {
//                ps.setInt(1, pizza.getId());
//                ps.setString(2, pizza.getNom());
//                ps.setFloat(3, pizza.getPrix());
//            }
//        });

		//Version 3 : Raccourci ! Les paramètres sont valorisés directement depuis l'instance passée
		String sql = "insert into pizza (id, nom, prix) values (:id, :nom, :prix)";
		int nbRows = namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(pizza));
		
		
		if(nbRows !=1) {
			throw new RuntimeException("Aucune ligne n'a été ajoutée ?!?");
		}
		
	}

	
	class PizzaRowMapper implements RowMapper<Pizza>
	{

		@Override
		public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pizza pizza = new Pizza();
			pizza.setId(rs.getInt("id"));
			pizza.setNom(rs.getString("nom"));
			pizza.setPrix(rs.getFloat("prix"));
			
			return pizza;
		}
		
	}
	
}








