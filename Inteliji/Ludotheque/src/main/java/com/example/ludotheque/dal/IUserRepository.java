package com.example.ludotheque.dal;

import com.example.ludotheque.bo.UserApplication;

import java.util.Optional;

public interface IUserRepository extends ICrudRepository<UserApplication> {
    Optional<UserApplication> getByLogin(String login);
}
