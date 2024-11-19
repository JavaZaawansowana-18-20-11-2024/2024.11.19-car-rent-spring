package com.comarch.szkolenia.car.rent.spring.database;

import com.comarch.szkolenia.car.rent.spring.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    List<User> findAll();
    Optional<User> findById(int id);
    void persist(User user);
}
