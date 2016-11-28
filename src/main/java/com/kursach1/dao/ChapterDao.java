package com.kursach1.dao;

import com.kursach1.domains.Chapter;

import java.util.Collection;

public interface ChapterDao {
    Collection<Chapter> getByCreativeId(Integer userId);
}
