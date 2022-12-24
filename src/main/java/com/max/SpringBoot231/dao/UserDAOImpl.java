package com.max.SpringBoot231.dao;

import com.max.SpringBoot231.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UserDAOImpl implements UserDAO {

    public UserDAOImpl() {

    }

    @PersistenceContext
    private EntityManager entityManager ;

    @Override
    public List<User> getAllUsers() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUser(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void deleteUser(int id) {
        Query query = entityManager.createQuery("delete from User where id =:userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }


}
