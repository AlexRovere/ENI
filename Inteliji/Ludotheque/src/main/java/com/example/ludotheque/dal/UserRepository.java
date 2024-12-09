package com.example.ludotheque.dal;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository implements IUserRepository{

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    UserRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Optional<User> getByLogin(String login) {
        String sql = "select * from users where login = :login";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("login", login);
        User dbUser = namedParameterJdbcTemplate.queryForObject(sql, params, ((ResultSet rs, int rowNum) ->  {
            String dbLogin = rs.getString("login");
            String password =  rs.getString("password");
            String role = rs.getString("roles");
            Collection<GrantedAuthority> roles = Arrays.stream(role.split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            return new User(dbLogin, password, roles);

        }));
        return Optional.ofNullable(dbUser);

    }
}
