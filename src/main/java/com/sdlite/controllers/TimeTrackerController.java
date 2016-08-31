package com.sdlite.controllers;

import com.sdlite.businesslogic.timetracker.TimeTrackerProcessor;
import com.sdlite.configuration.ConfigurationStorage;

import com.sdlite.controllers.forms.NewTimeRecordForm;
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
  @Autowired
  private TimeTrackerProcessor timeTrackerProcessor;

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
    model.addAttribute("newtimerecord", new NewTimeRecordForm());
    return "timetracker";
  }

  @RequestMapping(value = "/newtimerecord", method = RequestMethod.POST)
  public String newTimeRecord(@ModelAttribute NewTimeRecordForm newTimeRecordForm, Model model) {
    TimeTrackerRecord timeRecord =
            new TimeTrackerRecord(newTimeRecordForm.getName(), SecurityHelper.getCurrentUserId(userRepository));
    timeTrackerRepository.save(timeRecord);
    return "redirect:/timetracker/page/1";
  }

  @RequestMapping("/timetracker/start/{taskId}")
  public String startTask(@PathVariable Long taskId, Model model) {
    timeTrackerProcessor.startTask(taskId);
    return "redirect:/timetracker/page/1";
  }

  @RequestMapping("/timetracker/end/{taskId}")
  public String endTask(@PathVariable Long taskId, Model model) {
    timeTrackerProcessor.endTask(taskId);
    return "redirect:/timetracker/page/1";
  }

  @RequestMapping("/timetracker/pause/{taskId}")
  public String pauseTask(@PathVariable Long taskId, Model model) {
    timeTrackerProcessor.pauseTask(taskId);
    return "redirect:/timetracker/page/1";
  }

  @RequestMapping("/timetracker/delete/{taskId}")
  public String deleteTask(@PathVariable Long taskId, Model model) {
    timeTrackerProcessor.deleteTask(taskId);
    return "redirect:/timetracker/page/1";
  }

}
