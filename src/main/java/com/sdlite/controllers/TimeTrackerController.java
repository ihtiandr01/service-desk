package com.sdlite.controllers;

import com.sdlite.configuration.ConfigurationStorage;

import com.sdlite.domain.entities.TimeTrackerRecord;
import com.sdlite.domain.repositaries.*;
import com.sdlite.security.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.sdlite.configuration.ConfigurationKeys.SD_CONF_DATE_TIME_MASK_KEY;

@Controller
public class TimeTrackerController {

  @Autowired
  private TimeTrackerPagingRecordRepository timeTrackerRepository;
  @Autowired
  private ConfigurationStorage configurationStorage;
  @Autowired
  private UserRepository userRepository;

  @RequestMapping("/timetracker")
  public String timetracker(Model model, Pageable pageable) {
    return "redirect:/timetracker/page/1";
  }

  @RequestMapping("/timetracker/page/{pageNumber}")
  public String timeRecordsPaging(@PathVariable Integer pageNumber, Model model) {
    Page<TimeTrackerRecord> currentResults =
            timeTrackerRepository.findByUserId(SecurityHelper.getCurrentUserId(userRepository)
                    ,new PageRequest(pageNumber - 1, 20));
    PagingHelper.newInstance().createPagingModel(model, currentResults);
    model.addAttribute("datemask", configurationStorage.getValue(SD_CONF_DATE_TIME_MASK_KEY));
    return "timetracker";
  }

}
