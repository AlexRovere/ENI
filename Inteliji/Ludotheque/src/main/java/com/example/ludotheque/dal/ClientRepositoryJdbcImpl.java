package com.example.ludotheque.dal;

import com.example.ludotheque.Exception.EmailAlreadyTakenException;
import com.example.ludotheque.bo.Client;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class ClientRepositoryJdbcImpl implements IClientRepository {

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private JdbcTemplate jdbcTemplate;

    public ClientRepositoryJdbcImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void isClientEmailTaken(String email) throws EmailAlreadyTakenException {
        String sql = "SELECT COUNT(*) from clients where email = ?";
      Integer count=  jdbcTemplate.queryForObject(sql, Integer.class, email);
      if(count != null & count > 0) {
          throw new EmailAlreadyTakenException("Email déjà utilisé");
      }
    }


    @Override
    public void add(Client client) {
        String sql = "insert into clients (nom, prenom, email, no_tel, rue, code_postal, ville) VALUES (:nom, :prenom, :email, :noTel, :rue, :codePostal, :ville)";
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(client));
    }

    @Override
    public List<Client> getAll() {
        String sql = "select * from clients";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Client.class));
    }

    @Override
    public Optional<Client> getById(int id) {
        String sql = "select * from clients where no_client= ?";
       Client client = jdbcTemplate.queryForObject(sql, (ResultSet rs, int rowNum) -> {
            Client c = new Client();
            c.setNoClient(rs.getInt("no_client"));
            c.setNom(rs.getString("nom"));
            c.setPrenom(rs.getString("prenom"));
           c.setEmail(rs.getString("email"));
           c.setNoTel(rs.getString("no_tel"));
           c.setRue(rs.getString("rue"));
           c.setCodePostal(rs.getInt("code_postal"));
           c.setVille(rs.getString("ville"));

           return c;
        }, id);

        return Optional.ofNullable(client);
    }

    @Override
    public void update(Client client) {
    String sql = "update clients SET nom = :nom, prenom = :prenom, email = :email, no_tel = :noTel, rue = :rue, code_postal = :codePostal, ville = :ville where no_client = :noClient" ;
        namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(client));
    }

    @Override
    public void delete(int id) {
    String sql = "delete from clients where no_client = :id";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("id", id);
    namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public List<Client> getAllWithFilters(String filter) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from clients ");

        if(filter != null && !filter.isEmpty()) {
            sql.append("WHERE lower(nom || prenom || email) LIKE " + "'%").append(filter.toLowerCase()).append("%'");
        }
        return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(Client.class));
    }

    class ClientRowMapper implements RowMapper<Client> {

        @Override
        public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
            Client c = new Client();
            c.setNoClient(rs.getInt("no_client"));
            c.setNom(rs.getString("nom"));
            c.setPrenom(rs.getString("prenom"));
            c.setEmail(rs.getString("email"));
            c.setNoTel(rs.getString("no_tel"));
            c.setRue(rs.getString("rue"));
            c.setCodePostal(rs.getInt("code_postal"));
            c.setVille(rs.getString("ville"));
            return c;
        }
    }
}
