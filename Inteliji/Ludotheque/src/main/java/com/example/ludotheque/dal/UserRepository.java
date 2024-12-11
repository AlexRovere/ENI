package com.example.ludotheque.dal;

import com.example.ludotheque.bo.UserApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.*;

@Repository
public class UserRepository implements IUserRepository{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;

    UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, JdbcTemplate jdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.jdbcTemplate = jdbcTemplate;

    }

    @Override
    public Optional<UserApplication> getByLogin(String login) {
        String sql = "select * from users where login = :login";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("login", login);
        UserApplication user = namedParameterJdbcTemplate.queryForObject(sql, params, ((ResultSet rs, int rowNum) ->  {
            String dbLogin = rs.getString("login");
            String password =  rs.getString("password");
            String roles = rs.getString("roles");

            return new UserApplication(dbLogin, password, roles);

        }));
        return Optional.ofNullable(user);

    }

    public void add(UserApplication user) {
        String sql = "insert into users (login, password, roles) VALUES (:login, :password, 'USER')";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("login", user.getLogin());
        params.addValue("password", user.getPassword());
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void deleteUser(String login) {
        String sql = "delete FROM users where login= :login";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("login", login);
        namedParameterJdbcTemplate.update(sql, params);
    }

    public List<UserApplication> getAll() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserApplication.class));

    }

    @Override
    public Optional<UserApplication> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(UserApplication entity) {
        String sql = "update users SET roles = :roles where login = :login";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("roles", entity.getRoles());
        params.addValue("login", entity.getLogin());
        namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public void delete(int id) {

    }
}
