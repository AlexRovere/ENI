package com.example.ludotheque.dal;

import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface IUserRepository {
    Optional<User> getByLogin(String login);
}
