package com.sdlite.domain.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "sd_tickets")
public class Ticket implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Timestamp created;

    @Column(name = "user_name")
    private String authorName;

    @Column(name= "user_id")
    private Long authorId;

    protected Ticket() {
    }

    public Ticket(String name) {
        this.name = name;
        created = new Timestamp(System.currentTimeMillis());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreated() {
        return new Date(created.getTime());
    }

    public Long getId(){
        return id;
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", name=" + name + ", description=" + description + ", created=" + created + '}';
    }

}