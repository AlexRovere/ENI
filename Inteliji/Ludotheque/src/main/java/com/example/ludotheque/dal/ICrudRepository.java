package com.example.ludotheque.dal;

import com.example.ludotheque.bo.Client;

import java.util.List;
import java.util.Optional;

public interface ICrudRepository<T> {
    void add(T entity);

    public List<T> getAll();

    Optional<T> getById(int id);

    void update(T entity);

    void delete(int id);
}
