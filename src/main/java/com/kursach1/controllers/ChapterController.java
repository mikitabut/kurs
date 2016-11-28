package com.kursach1.controllers;

import com.kursach1.domains.Chapter;
import com.kursach1.services.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value ="/api/chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @RequestMapping(value = "/getByCreativeId",method = RequestMethod.GET)
    public Collection<Chapter> getByCreativeId(@RequestParam Integer creativeId) {
        return chapterService.getByCreativeId(creativeId);
    }
}
