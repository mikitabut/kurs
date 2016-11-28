package com.kursach1.dao.daoImpl;

import com.kursach1.dao.CreativeDao;
import com.kursach1.domains.Creative;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Repository
public class CreativeDaoImpl implements CreativeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Creative> getByUserId(Integer userId) {

        List<Creative> resultList = entityManager.createQuery("from Creative where user_id="+userId, Creative.class).getResultList();
        return resultList;
    }
}
