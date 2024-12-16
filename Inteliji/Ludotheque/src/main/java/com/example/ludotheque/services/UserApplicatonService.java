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
        this.userRepository = userRepository;
    }

    @Override
    public void add(UserApplication entity) {
        this.userRepository.add(entity);
    }

    public List<UserApplication> getAll() {
        return this.userRepository.getAll();
    }

    @Override
    public Optional<UserApplication> getById(int id) {
        return this.userRepository.getById(id);
    }

    @Override
    public void update(UserApplication entity) {
        this.userRepository.update(entity);
    }

    @Override
    public void delete(int id) {
        this.userRepository.delete(id);
    }

}
