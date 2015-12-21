package com.sdlite.controllers;


import com.sdlite.domain.entities.User;
import com.sdlite.domain.repositaries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/users")
    public String users(Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public String showUser(@PathVariable Long userId, Model model) {
        model.addAttribute("user",userRepository.findOne(userId));
        return "user";
    }


}
