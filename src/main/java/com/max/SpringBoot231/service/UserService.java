package com.max.SpringBoot231.service;

import com.max.SpringBoot231.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
