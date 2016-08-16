package com.sdlite.controllers;

import com.sdlite.configuration.ConfigurationStorage;
import com.sdlite.controllers.forms.NewCommentForm;
import com.sdlite.controllers.forms.NewTicketForm;
import com.sdlite.domain.UserHelper;
import com.sdlite.domain.entities.Ticket;
import com.sdlite.domain.entities.TicketComment;
import com.sdlite.domain.entities.TimeTrackerRecord;
import com.sdlite.domain.entities.User;
import com.sdlite.domain.entities.builders.TicketBuilder;
import com.sdlite.domain.repositaries.*;
import com.sdlite.security.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sdlite.configuration.ConfigurationKeys.SD_CONF_DATE_TIME_MASK_KEY;

@Controller
public class TimeTrackerController {

  @Autowired
  private TimeTrackerPagingRecordRepository timeTrackerRepository;
  @Autowired
  private ConfigurationStorage configurationStorage;

  @RequestMapping("/timetracker")
  public String timetracker(Model model, Pageable pageable) {
    return "redirect:/timetracker/page/1";
  }

  @RequestMapping("/timetracker/page/{pageNumber}")
  public String timeRecordsPaging(@PathVariable Integer pageNumber, Model model) {
    Page<TimeTrackerRecord> currentResults = timeTrackerRepository.findAll(new PageRequest(pageNumber - 1, 20));
    PagingHelper.newInstance().createPagingModel(model, currentResults);
    model.addAttribute("datemask", configurationStorage.getValue(SD_CONF_DATE_TIME_MASK_KEY));
    return "timetracker";
  }

}
