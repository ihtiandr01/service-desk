package com.sdlite.domain.entities.builders;


import com.sdlite.domain.entities.User;

public class UserBuilder {

    private String name;
    private String email;
    private String password;
    private String role;
    private String login;

    private UserBuilder(){}

    public static UserBuilder newInstance(){
        return new UserBuilder();
    }

    public User build(){
        if(name == null) throw new IllegalArgumentException("User must have name");
        if (login == null) throw new IllegalArgumentException("User must have login");
        User user = new User(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        user.setLogin(login);
        return user;
    }

    public UserBuilder setName(String name){
        this.name = name;
        return this;
    }

    public UserBuilder setEmail(String email){
        this.email = email;
        return this;
    }

    public UserBuilder setPassword(String password){
        this.password = password;
        return this;
    }

    public  UserBuilder setRole(String role){
        this.role = role;
        return this;
    }

    public UserBuilder setLogin(String login){
        this.login = login;
        return this;
    }

}
