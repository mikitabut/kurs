package com.kursach1.dao;

import com.kursach1.domains.User;

import java.util.Collection;

/**
 * @author Vlad Fefelov
 */
public interface UserDao {

    Collection<User> getAll();

    void add(User user);

    void remove(Integer userId);

    User getById(Integer id);
}
