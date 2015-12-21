package com.sdlite.controllers;

import com.sdlite.controllers.forms.NewCommentForm;
import com.sdlite.controllers.forms.NewTicketForm;
import com.sdlite.domain.entities.Ticket;
import com.sdlite.domain.entities.TicketComment;
import com.sdlite.domain.entities.builders.TicketBuilder;
import com.sdlite.domain.repositaries.TicketCommentRepository;
import com.sdlite.domain.repositaries.TicketRepository;
import com.sdlite.security.SecurityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Iterator;
import java.util.List;

@Controller
public class TicketsController {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketCommentRepository commentRepository;

    @RequestMapping("/tickets")
    public String tickets(Model model) {
        Iterable<Ticket> tickets = ticketRepository.findAll();
        model.addAttribute("tickets", tickets);
        return "tickets";
    }

    @RequestMapping(value = "/newticket", method = RequestMethod.GET)
    public String newTicketForm(Model model) {
        model.addAttribute("newticket", new NewTicketForm());
        return "newticket";
    }

    @RequestMapping(value = "/newticket", method = RequestMethod.POST)
    public String submitNewTicket(@ModelAttribute NewTicketForm newTicketForm, Model model) {
        Ticket ticket = TicketBuilder.newInstance()
                .setName(newTicketForm.getName())
                .setDescription(newTicketForm.getDescription())
                .build();
        ticketRepository.save(ticket);
        return "redirect:/tickets";
    }

    @RequestMapping(value = "/ticket/{ticketId}", method = RequestMethod.GET)
    public String showTicket(@PathVariable Long ticketId, Model model) {
        model.addAttribute("newcomment", new NewCommentForm());
        List<TicketComment> comments = commentRepository.findByTicketId(ticketId);
        model.addAttribute("comments", comments);
        model.addAttribute("ticket", ticketRepository.findOne(ticketId));
        return "ticket";
    }

    @RequestMapping(value = "/ticket/{ticketId}/newcomment", method = RequestMethod.POST)
    public String submitNewComment(@PathVariable Long ticketId, @ModelAttribute NewCommentForm newCommentForm, Model model) {

        //TODO: add builder for comments
        TicketComment comment = new TicketComment(ticketId, newCommentForm.getComment(), SecurityHelper.getCurrentUsername(),0L);
        commentRepository.save(comment);
        return "redirect:/ticket/" + ticketId;
    }

    @RequestMapping(value = "/ticket/{ticketId}/edit", method = RequestMethod.POST)
    public String editTicket(){
        //TODO: Add functional for ticket edition
        return "edit_ticket";
    }


}
