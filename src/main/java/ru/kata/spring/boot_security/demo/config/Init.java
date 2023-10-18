package ru.kata.spring.boot_security.demo.config;

import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.entity.Role;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Init {

    private final UserService userService;

    private final RoleService roleService;

    public Init(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void initDB() {

        Role roleAdmin = new Role(1L, "ROLE_ADMIN");
        Role roleUser = new Role(2L, "ROLE_USER");

        List<Role> adminList = new ArrayList<>();
        List<Role> userList = new ArrayList<>();

        roleService.addRole(roleAdmin);
        roleService.addRole(roleUser);

        adminList.add(roleAdmin);
        userList.add(roleUser);

        User admin = new User("Admin", "Adminov", 25, "admin@mail.ru", "1111", adminList);
        admin.setId(1L);

        User user = new User("User", "Userov", 40, "user@mail.ru", "2222", userList);
        user.setId(2L);

        userService.saveUser(admin);
        userService.saveUser(user);
    }
}