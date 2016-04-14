package com.sdlite.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sd_settings")
public class ConfigurationItem {

  @Id
  @Column(name = "key", nullable = false)
  private String key;
  @Column(name = "value")
  private String value;

  protected ConfigurationItem() {
  }

  public ConfigurationItem(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
