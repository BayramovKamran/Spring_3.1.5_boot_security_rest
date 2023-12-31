package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;

public interface RoleService {

    void add(Role role);

    List<Role> findAll();

    Role show(Long id);

    void delete(Long id);
}