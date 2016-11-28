package com.kursach1.services.servicesImpl;

import com.kursach1.dao.ChapterDao;
import com.kursach1.domains.Chapter;
import com.kursach1.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Transactional
@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterDao chapterDao;

    @Override
    public Collection<Chapter> getByCreativeId(Integer creativeId) {
        return chapterDao.getByCreativeId(creativeId);
    }
}
