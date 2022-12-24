package com.max.SpringBoot231.dao;

import com.max.SpringBoot231.model.User;
import java.util.List;

public interface UserDAO {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);
}
