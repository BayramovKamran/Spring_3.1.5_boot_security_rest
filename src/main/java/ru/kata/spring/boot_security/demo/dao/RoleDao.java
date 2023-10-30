package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;

public interface RoleDao {

    void add(Role role);

    List<Role> findAll();

    Role show(Long id);

    void delete(Long id);
}