package com.example.ludotheque.dal;

import com.example.ludotheque.bo.UserApplication;
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
    public Optional<UserApplication> getByLogin(String login) {
        String sql = "select * from users where login = :login";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("login", login);
        UserApplication user = namedParameterJdbcTemplate.queryForObject(sql, params, ((ResultSet rs, int rowNum) ->  {
            String dbLogin = rs.getString("login");
            String password =  rs.getString("password");
            String roles = rs.getString("roles");

//            Collection<GrantedAuthority> roles = Arrays.stream(role.split(","))
//                    .map(SimpleGrantedAuthority::new)
//                    .collect(Collectors.toList());

            return new UserApplication(dbLogin, password, roles);

        }));
        return Optional.ofNullable(user);

    }

    public void addUser(UserApplication user) {
        String sql = "insert into users (login, password, roles) VALUES (:login, :password, 'USER')";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("login", user.getLogin());
        params.addValue("password", user.getPassword());
        namedParameterJdbcTemplate.update(sql, params);

    }
}
