package com.sdlite.controllers;

import com.sdlite.common.TicketStatus;
import com.sdlite.domain.entities.Ticket;
import com.sdlite.domain.entities.User;
import com.sdlite.domain.repositaries.TicketRepository;
import com.sdlite.domain.repositaries.UserRepository;
import com.sdlite.security.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private TicketRepository ticketRepository;

  @RequestMapping("/")
  public String home(Model model) {
    String currentLogin = SecurityHelper.getCurrentUsername();
    model.addAttribute("currentUser", currentLogin);
    User currentUser = userRepository.findOneByLogin(currentLogin);
    String currentUserName = currentUser.getName();
    Iterable<Ticket> assignedTickets = ticketRepository.findByAssignName(currentUserName);
    model.addAttribute("assignedTickets", assignedTickets);
    Iterable<Ticket> createdTickets = ticketRepository.findByAuthorName(currentUserName);
    model.addAttribute("createdTickets", createdTickets);
    Iterable<Ticket> newTickets = ticketRepository.findByStatus(TicketStatus.NEW.getValue());
    model.addAttribute("newTickets", newTickets);
    return "home";
  }
}



