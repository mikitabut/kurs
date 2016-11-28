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

    @Override
    public Collection<Creative> getByCreativeId(Integer creativeId, Integer count) {
        List<Creative> resultList;
        if(creativeId==-1) {
             resultList= entityManager.createQuery("from Creative ORDER By date DESC", Creative.class)
                     .setMaxResults(count)
                     .getResultList();
        }
        else {
            resultList = entityManager.createQuery("from Creative ORDER By date DESC", Creative.class)
                    .setFirstResult(creativeId)
                    .setMaxResults(count)
                    .getResultList();
        }
        return resultList;
    }

    @Override
    public Creative getCreativeById(Integer creativeId) {
        return entityManager.find(Creative.class,creativeId);
    }
}
