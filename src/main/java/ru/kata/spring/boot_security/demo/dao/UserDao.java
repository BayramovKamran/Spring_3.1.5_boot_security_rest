package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

public interface UserDao {

    void add(User user);

    void update (User user);

    List<User> findAll();

    User show(Long id);

    void delete(Long id);

    User findByUsername (String username);
}