package com.sdlite.domain.entities;

import com.sdlite.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserTest {

    @Test
    public void testUserEntity() {
        User user = new User("User Test");
        user.setName("Name");
        user.setEmail("Email");
        user.setPassword("Password");
        user.setRole("Role");

        assertThat(user.getName(), is("Name"));
        assertThat(user.getEmail(), is("Email"));
        assertThat(user.getPassword(), is("Password"));
        assertThat(user.getRole(), is("Role"));
    }

}
