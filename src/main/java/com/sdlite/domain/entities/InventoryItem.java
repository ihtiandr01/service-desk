package com.sdlite.domain.entities;


import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "sd_inventory")
public class InventoryItem {
  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String name;
  private String uuid;
  private String description;
  @Column(nullable = false)
  private Timestamp created;

  protected InventoryItem() {
  }

  public InventoryItem(String name) {
    this.name = name;
    created = new Timestamp(System.currentTimeMillis());
    uuid = java.util.UUID.randomUUID().toString();
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

  public Long getId() {
    return id;
  }

  public Date getCreated() {
    return new Date(created.getTime());
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }
}
