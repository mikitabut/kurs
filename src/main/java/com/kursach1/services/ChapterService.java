package com.kursach1.services;

import com.kursach1.domains.Chapter;

import java.util.Collection;

public interface ChapterService {
    Collection<Chapter> getByCreativeId(Integer creativeId);
}
