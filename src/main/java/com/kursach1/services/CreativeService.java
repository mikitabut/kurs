package com.kursach1.services;

import com.kursach1.domains.Creative;

import java.util.Collection;

public interface CreativeService {
    Collection<Creative> getByUserId(Integer userId);
}
