package com.sdlite.businesslogic.timetracker;


public enum TimeRecordStatus {
  NEW("NEW"),
  IN_PROGRESS("IN PROGRESS"),
  ENDED("ENDED"),
  PAUSED("PAUSED");

  private String value;

  TimeRecordStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
