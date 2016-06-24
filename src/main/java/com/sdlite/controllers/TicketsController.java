package com.sdlite.controllers;

import com.sdlite.configuration.ConfigurationStorage;
import com.sdlite.controllers.forms.NewCommentForm;
import com.sdlite.controllers.forms.NewTicketForm;
import com.sdlite.domain.UserHelper;
import com.sdlite.domain.entities.Ticket;
import com.sdlite.domain.entities.TicketComment;
import com.sdlite.domain.entities.User;
import com.sdlite.domain.entities.builders.TicketBuilder;
import com.sdlite.domain.repositaries.TicketCommentRepository;
import com.sdlite.domain.repositaries.TicketPagingRepository;
import com.sdlite.domain.repositaries.UserRepository;
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
public class TicketsController {

  @Autowired
  TicketPagingRepository ticketRepository;
  @Autowired
  TicketCommentRepository commentRepository;
  @Autowired
  UserRepository userRepository;
  @Autowired
  UserHelper userHelper;
  @Autowired
  private ConfigurationStorage configurationStorage;

  @RequestMapping("/tickets")
  public String tickets(Model model, Pageable pageable) {
    return "redirect:/tickets/page/1";
  }

  @RequestMapping("/tickets/page/{pageNumber}")
  public String ticketsPaging(@PathVariable Integer pageNumber, Model model) {
    Page<Ticket> currentResults = ticketRepository.findAll(new PageRequest(pageNumber - 1, 20));
    PagingHelper.newInstance().createPagingModel(model, currentResults);
    model.addAttribute("datemask", configurationStorage.getValue(SD_CONF_DATE_TIME_MASK_KEY));
    return "tickets";
  }


  @RequestMapping(value = "/newticket", method = RequestMethod.GET)
  public String newTicketForm(Model model) {
    model.addAttribute("newticket", new NewTicketForm());
    model.addAttribute("currentUser", SecurityHelper.getCurrentUsername());
    return "newticket";
  }

  @RequestMapping(value = "/newticket", method = RequestMethod.POST)
  public String submitNewTicket(@ModelAttribute NewTicketForm newTicketForm, Model model) {
    Ticket ticket = TicketBuilder.newInstance()
            .setName(newTicketForm.getName())
            .setDescription(newTicketForm.getDescription())
            .setAssignName(newTicketForm.getAssign())
            .setPriority(newTicketForm.getPriority())
            .build();
    ticketRepository.save(ticket);
    return "redirect:/tickets";
  }

  @RequestMapping(value = "/assign_list", method = RequestMethod.GET, headers = "Accept=*/*")
  public
  @ResponseBody
  Iterable<User> getAssignList(@RequestParam("term") String query) {
    return userHelper.findByLikeName(query);
  }

  @RequestMapping(value = "/ticket/{ticketId}", method = RequestMethod.GET)
  public String showTicket(@PathVariable Long ticketId, Model model) {
    model.addAttribute("newcomment", new NewCommentForm());
    List<TicketComment> comments = commentRepository.findByTicketId(ticketId);
    model.addAttribute("comments", comments);
    model.addAttribute("ticket", ticketRepository.findOne(ticketId));
    model.addAttribute("currentUser", SecurityHelper.getCurrentUsername());
    model.addAttribute("datemask", configurationStorage.getValue(SD_CONF_DATE_TIME_MASK_KEY));
    return "ticket";
  }

  @RequestMapping(value = "/ticket/{ticketId}/newcomment", method = RequestMethod.POST)
  public String submitNewComment(@PathVariable Long ticketId, @ModelAttribute NewCommentForm newCommentForm, Model model) {

    //TODO: add builder for comments
    TicketComment comment = new TicketComment(ticketId, newCommentForm.getComment(), SecurityHelper.getCurrentUsername(), 0L);
    commentRepository.save(comment);
    return "redirect:/ticket/" + ticketId;
  }

  @RequestMapping(value = "/ticket/{ticketId}/edit", method = RequestMethod.POST)
  public String editTicket() {
    //TODO: Add functional for ticket edition
    return "edit_ticket";
  }


}
