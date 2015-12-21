package com.sdlite.domain.entities;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "sd_users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="name",nullable = false)
    private String name;
    
    @Column(name="email")
    private String email;
    
    @Column(name="password")
    private String password;
    
    @Column(name="created",nullable = false)
    private Timestamp created;

    @Column(name="role")
    private String role;
    
    protected User(){
    }
    
    public User(String name){
        this.name = name;
        created = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", email=" + email + ", created=" + created + '}';
    }
    

}
