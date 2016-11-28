package com.kursach1.dao;

import com.kursach1.domains.Creative;

import java.util.Collection;

public interface CreativeDao {
    Collection<Creative> getByUserId(Integer userId);

    Collection<Creative> getByCreativeId(Integer creativeId, Integer count);

    Creative getCreativeById(Integer creativeId);
}
