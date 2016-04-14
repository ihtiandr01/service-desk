package com.sdlite.common;

public enum TicketStatus {
  NEW("New"),
  IN_PROGRESS("In Progress"),
  CLOSED("Closed"),
  RESOLVED("Resolved");

  private String value;

  TicketStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
