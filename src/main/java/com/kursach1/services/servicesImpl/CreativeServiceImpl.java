package com.kursach1.services.servicesImpl;

import com.kursach1.dao.CreativeDao;
import com.kursach1.domains.Creative;
import com.kursach1.services.CreativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@Service
public class CreativeServiceImpl implements CreativeService {

    @Autowired
    private CreativeDao creativeDao;

    @Override
    public Collection<Creative> getByUserId(Integer userId) {
        return creativeDao.getByUserId(userId);
    }

    @Override
    public Collection<Creative> getByCreativeId(Integer creativeId, Integer count) {
        return creativeDao.getByCreativeId(creativeId,count);
    }

    @Override
    public Creative getCreativeById(Integer creativeId) {
        return creativeDao.getCreativeById(creativeId);
    }
}
