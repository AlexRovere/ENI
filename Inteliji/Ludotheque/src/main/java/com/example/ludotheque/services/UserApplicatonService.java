package com.example.ludotheque.services;

import com.example.ludotheque.bo.UserApplication;
import com.example.ludotheque.dal.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserApplicatonService implements IUserApplicationService {

    IUserRepository userRepository;
    UserApplicatonService(IUserRepository userRepository) {
        this.userRepository= userRepository;
    }

    @Override
    public void add(UserApplication entity) {

    }

    public List<UserApplication> getAll() {
        return this.userRepository.getAll();
    }

    @Override
    public Optional<UserApplication> getById(int id) {
        return Optional.empty();
    }

    @Override
    public void update(UserApplication entity) {
        this.userRepository.update(entity);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void deleteUser(String login) {
        this.userRepository.deleteUser(login);
    }

    public Optional<UserApplication> getByLogin(String login) {
        return this.userRepository.getByLogin(login);
    }
}
