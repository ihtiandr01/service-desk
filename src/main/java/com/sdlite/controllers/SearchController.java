package com.sdlite.controllers;


import com.sdlite.configuration.ConfigurationStorage;
import com.sdlite.controllers.forms.SearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SearchController {
  @Autowired
  private ConfigurationStorage configurationStorage;
  @RequestMapping(value = "/search", method = RequestMethod.POST)
  public String search(@ModelAttribute SearchForm searchForm, Model model) {
    return "search";
  }

}
