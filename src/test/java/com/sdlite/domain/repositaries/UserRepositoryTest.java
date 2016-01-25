package com.sdlite.domain.repositaries;

import com.sdlite.Application;
import com.sdlite.domain.entities.User;
import com.sdlite.domain.entities.builders.UserBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testTicketRepository() {
        long id = userRepository.save(UserBuilder.newInstance()
                .setName("Test User #001")
                .setLogin("user1").build()).getId();
        User user = userRepository.findOne(id);
        assertThat(user.getName(),is("Test User #001"));
        List<User> users = userRepository.findByName("Test User #001");
        assertThat(users.isEmpty(), is(false));
        assertThat(users.get(0).getName(), is("Test User #001"));
    }


}
