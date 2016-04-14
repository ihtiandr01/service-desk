package com.sdlite.domain.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "sd_ticket_comments")
public class TicketComment {
  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "ticket_id", nullable = false)
  private Long ticketId;
  @Column(name = "comment", nullable = false)
  private String comment;
  @Column(name = "created", nullable = false)
  private Timestamp created;
  @Column(name = "user_name")
  private String authorName;
  @Column(name = "user_id")
  private Long authorId;

  protected TicketComment() {
  }

  public TicketComment(Long ticketId, String comment, String authorName, Long authorId) {
    this.ticketId = ticketId;
    this.comment = comment;
    this.authorName = authorName;
    this.authorId = authorId;
    created = new Timestamp(System.currentTimeMillis());
  }


  public Date getCreated() {
    return new Date(created.getTime());
  }

  public Long getId() {
    return id;
  }

  public Long getTicketId() {
    return ticketId;
  }

  public void setTicketId(Long ticketId) {
    this.ticketId = ticketId;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }

  @Override
  public String toString() {
    return "TicketComment{" +
            "id=" + id +
            ", ticketId=" + ticketId +
            ", comment='" + comment + '\'' +
            ", created=" + created +
            '}';
  }
}
