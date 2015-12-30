package com.sdlite.domain.repositaries;

import com.sdlite.Application;
import com.sdlite.domain.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Test
    public void testTicketRepository() {
        long id = userRepository.save(new User("Test Ticket #001")).getId();

        User user = userRepository.findOne(id);
        assertThat(user.getName(),is("Test Ticket #001"));

        List<User> tickets = userRepository.findByName("Test Ticket #001");
        assertThat(tickets.isEmpty(), is(false));
        assertThat(tickets.get(0).getName(), is("Test Ticket #001"));
    }
}
