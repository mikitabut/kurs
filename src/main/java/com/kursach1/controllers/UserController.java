package com.kursach1.controllers;

import com.kursach1.domains.User;
import com.kursach1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author Vlad Fefelov
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public Collection<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Collection<User> add(@RequestBody User user){
        userService.add(user);
        return getAll();
    }

    @RequestMapping(value = "/remove",method = RequestMethod.DELETE)
    public Collection<User> remove(@RequestParam Integer userId) {
        userService.remove(userId);
        return getAll();
    }
    @RequestMapping(value = "/getById",method = RequestMethod.GET)
    public User getById(@RequestParam Integer userId) {
        return userService.getById(userId);
    }

}
