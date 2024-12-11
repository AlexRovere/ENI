package com.example.ludotheque.services;

import com.example.ludotheque.bo.UserApplication;

import java.util.Optional;


public interface IUserApplicationService extends ICrudService<UserApplication> {
    void deleteUser(String login);
    Optional<UserApplication> getByLogin(String login);
}
