package com.kursach1.controllers;

import com.kursach1.services.UserService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Collection;

@Controller
public class WebPagesController {

    @RequestMapping(value={"/","/home"})
    public ModelAndView homeGoing(){
        return new ModelAndView("home");
    }

    @RequestMapping(value={"/register"})
    public ModelAndView register(HttpResponse httpResponse){
        return new ModelAndView("register");
    }

    @RequestMapping(value="/admin")
    public ModelAndView admin(){
        return new ModelAndView("admin");
    }

    @RequestMapping(value={"/login"})
    public ModelAndView login(){
        return new ModelAndView("login");
    }


    @RequestMapping(value="/403")
    public ModelAndView Error403(){
        return new ModelAndView("403");
    }

    @RequestMapping(value="/users")
    public ModelAndView Users(){
        return new ModelAndView("users");
    }

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public WebPagesController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @RequestMapping(value="/facebookAfter")
    public ModelAndView facebookAfter(Model model){
        String [] fields = { "email",  "first_name", "last_name" };
        User userProfile = facebook.fetchObject("me", User.class, fields);
        model.addAttribute("Email", userProfile.getFirstName()+"@"+userProfile.getLastName());
        model.addAttribute("FirstName", userProfile.getFirstName());
        model.addAttribute("LastName", userProfile.getLastName());

        return new ModelAndView("connect/facebookAfter");
    }

    @Autowired
    UserService userService;
    @Autowired

    @RequestMapping(value="/user/{id}")
    public ModelAndView User(@PathVariable int id, Model model, Principal principal){
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();

        if(authorities.toArray()[0].toString().equals("ROLE_ADMIN"))
            model.addAttribute("who",authorities.toArray()[0].toString());
        else
            model.addAttribute("who",principal.getName());
        com.kursach1.domains.User user = userService.getById(id);
        String email = user.getEmail();
        model.addAttribute("pageUser",email);
        model.addAttribute("nextpage","/user/"+id+"/creative");
        return new ModelAndView("user");
    }

    @RequestMapping(value="/user/{id}/creative/{crid}")
    public ModelAndView createCreative(@PathVariable int id, Model model, Principal principal){

        return new ModelAndView("changeCreative");
    }

}