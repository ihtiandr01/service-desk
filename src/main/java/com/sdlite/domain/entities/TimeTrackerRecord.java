package com.sdlite.domain.entities;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sd_timetracker")
public class TimeTrackerRecord {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "ticket_id")
  private Long ticketId;
  @Column(name = "user_id")
  private Long userId;
  @Column(name = "name", nullable = false)
  private String name;
  @Column(name = "description")
  private String description;
  @Column(name = "duration")
  private Timestamp duration;
  @Column(name = "start_date")
  private Timestamp startDate;
  @Column(name = "end_date")
  private Timestamp endDate;
  @Column(name = "created", nullable = false)
  private Timestamp created;

  protected TimeTrackerRecord() {
  }

  public TimeTrackerRecord(String name, long userId) {
    this.userId= userId;
    this.name = name;
    created = new Timestamp(System.currentTimeMillis());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Timestamp getDuration() {
    return duration;
  }

  public void setDuration(Timestamp duration) {
    this.duration = duration;
  }

  public Timestamp getStartDate() {
    return startDate;
  }

  public void setStartDate(Timestamp startDate) {
    this.startDate = startDate;
  }

  public Timestamp getEndDate() {
    return endDate;
  }

  public void setEndDate(Timestamp endDate) {
    this.endDate = endDate;
  }

  public Timestamp getCreated() {
    return created;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "TimeTrackerRecord{" +
            "id=" + id +
            ", ticketId=" + ticketId +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", duration=" + duration +
            ", startDate=" + startDate +
            ", endDate=" + endDate +
            ", created=" + created +
            '}';
  }
}
