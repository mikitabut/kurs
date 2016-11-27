package com.kursach1.dao.daoImpl;

import com.kursach1.domains.User;
import com.kursach1.dao.UserDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

/**
 * @author Vlad Fefelov
 */
@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public Collection<User> getAll() {
        List<User> resultList = entityManager.createQuery("from User", User.class).getResultList();

        return resultList;
    }

    @Override
    public void remove(Integer user_id) {
        User user = entityManager.find(User.class, user_id);
        if (null != user) {
            entityManager.remove(user);
        }
    }

    @Override
    public User getById(Integer id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

}
