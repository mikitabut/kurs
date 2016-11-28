package com.kursach1.dao.daoImpl;

import com.kursach1.dao.ChapterDao;
import com.kursach1.domains.Chapter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;
import java.util.List;

@Repository
public class ChapterDaoImpl implements ChapterDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Collection<Chapter> getByCreativeId(Integer creativeId) {
        List<Chapter> resultList = entityManager.createQuery("from Chapter where creative_id="+creativeId.toString(), Chapter.class).getResultList();
        return resultList;
    }
}
