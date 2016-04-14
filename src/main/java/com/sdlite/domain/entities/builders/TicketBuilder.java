package com.sdlite.domain.entities.builders;

import com.sdlite.common.TicketStatus;
import com.sdlite.domain.entities.Ticket;

public class TicketBuilder {

  private String name;

  private String description;

  private String authorName;

  private Long authorId;

  private Long assignId;

  private String assignName;

  private String priority;

  private String status;

  private TicketBuilder() {

  }

  public static TicketBuilder newInstance() {
    return new TicketBuilder();
  }

  public Ticket build() {
    if (name == null) throw new IllegalArgumentException("Ticket must have name");
    Ticket ticket = new Ticket(name);
    if (description != null) {
      ticket.setDescription(description);
    }
    if (authorName != null && authorId != null) {
      ticket.setAuthorId(authorId);
      ticket.setAuthorName(authorName);
    }
    ticket.setAssignId(assignId);
    ticket.setAssignName(assignName);
    ticket.setPriority(priority);
    if (status == null) status = TicketStatus.NEW.getValue();
    ticket.setStatus(status);

    return ticket;
  }

  public TicketBuilder setDescription(String description) {
    this.description = description;
    return this;
  }

  public TicketBuilder setName(String name) {
    this.name = name;
    return this;
  }

  public TicketBuilder setAuthorName(String authorName) {
    this.authorName = authorName;
    return this;
  }

  public TicketBuilder setAuthorId(Long authorId) {
    this.authorId = authorId;
    return this;
  }

  public TicketBuilder setAssignId(Long assignId) {
    this.assignId = assignId;
    return this;
  }

  public TicketBuilder setAssignName(String assignName) {
    this.assignName = assignName;
    return this;
  }

  public TicketBuilder setPriority(String priority) {
    this.priority = priority;
    return this;
  }

  public TicketBuilder setStatus(String status) {
    this.status = status;
    return this;
  }
}
