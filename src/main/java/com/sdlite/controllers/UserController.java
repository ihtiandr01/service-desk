package com.sdlite.controllers;


import com.sdlite.controllers.forms.NewUserForm;
import com.sdlite.domain.entities.User;
import com.sdlite.domain.entities.builders.UserBuilder;
import com.sdlite.domain.repositaries.UserRepository;
import com.sdlite.security.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {

  @Autowired
  UserRepository userRepository;

  @RequestMapping("/users")
  public String users(Model model) {
    Iterable<User> users = userRepository.findAll();
    model.addAttribute("users", users);
    model.addAttribute("currentUser", SecurityHelper.getCurrentUsername());
    return "users";
  }

  @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
  public String showUser(@PathVariable Long userId, Model model) {
    model.addAttribute("user", userRepository.findOne(userId));
    model.addAttribute("currentUser", SecurityHelper.getCurrentUsername());
    return "user";
  }


  @RequestMapping(value = "/newuser", method = RequestMethod.GET)
  public String newUserForm(Model model) {
    model.addAttribute("newuser", new NewUserForm());
    model.addAttribute("currentUser", SecurityHelper.getCurrentUsername());
    return "newuser";
  }

  @RequestMapping(value = "/newuser", method = RequestMethod.POST)
  public String submitNewTicket(@ModelAttribute NewUserForm newUserForm, Model model) {
    User user = UserBuilder.newInstance()
            .setName(newUserForm.getName())
            .setPassword(newUserForm.getPassword())
            .setEmail(newUserForm.getEmail())
            .build();
    userRepository.save(user);
    return "redirect:/users";
  }


}
