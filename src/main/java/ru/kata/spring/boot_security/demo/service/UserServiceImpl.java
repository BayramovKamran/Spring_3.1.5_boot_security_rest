package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void add(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.add(user);
    }

    @Override
    public User show(Long id) {
        return userDao.show(id);
    }

    @Transactional
    @Override
    public void update(Long id, User user) {
        User userToBeUpdated = userDao.show(id);
        userToBeUpdated.setFirstName(user.getFirstName());
        userToBeUpdated.setLastName(user.getLastName());
        userToBeUpdated.setRoles(user.getRoles());
        if (!userToBeUpdated.getPassword().equals(user.getPassword())) {
            userToBeUpdated.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userDao.update(userToBeUpdated);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}