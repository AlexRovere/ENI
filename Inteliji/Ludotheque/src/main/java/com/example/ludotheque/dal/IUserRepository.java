package com.example.ludotheque.dal;

import com.example.ludotheque.bo.UserApplication;

import java.util.Optional;

public interface IUserRepository {
    Optional<UserApplication> getByLogin(String login);
    void addUser(UserApplication user);
}
