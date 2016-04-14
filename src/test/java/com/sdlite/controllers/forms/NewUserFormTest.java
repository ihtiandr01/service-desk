package com.sdlite.controllers.forms;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NewUserFormTest {

  @Test
  public void testNewUserForm() {
    NewUserForm userForm = new NewUserForm();
    userForm.setName("User Name");
    userForm.setEmail("user@sd.com");
    userForm.setPassword("123");
    userForm.setRole("USER");
    userForm.setLogin("user1");

    assertThat(userForm.getName(), is("User Name"));
    assertThat(userForm.getEmail(), is("user@sd.com"));
    assertThat(userForm.getPassword(), is("123"));
    assertThat(userForm.getRole(), is("USER"));
    assertThat(userForm.getLogin(), is("user1"));
  }

}
