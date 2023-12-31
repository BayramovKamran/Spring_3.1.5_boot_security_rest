package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Role role) {
        entityManager.persist(role);
    }

    @Override
    public List<Role> findAll() {
        return entityManager.createQuery("SELECT DISTINCT r FROM Role r").getResultList();
    }

    @Override
    public Role show(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }
}