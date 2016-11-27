package com.kursach1.services.servicesImpl;

import com.kursach1.dao.UserDao;
import com.kursach1.domains.User;
import com.kursach1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * @author Vlad Fefelov
 */
@Transactional
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public Collection<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Override
    public void remove(Integer userId) {
        userDao.remove(userId);
    }

    @Override
    public User getById(Integer userId) {
        return userDao.getById(userId);
    }
}
