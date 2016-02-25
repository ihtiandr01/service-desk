package com.sdlite.controllers;

import com.sdlite.domain.repositaries.SettingsRepository;
import com.sdlite.security.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {

    @Autowired
    SettingsRepository settingsRepository;

    @RequestMapping("/config")
    public String home(Model model){
        model.addAttribute("confItem", settingsRepository.findOneByKey("sd.confitem.date_time_mask"));
        model.addAttribute("currentUser",  SecurityHelper.getCurrentUsername());
        return "config";
    }
}
