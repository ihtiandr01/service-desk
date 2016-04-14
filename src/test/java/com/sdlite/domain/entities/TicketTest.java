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
public class TicketTest {

  @Test
  public void testTicketEntity() {
    Ticket ticket = new Ticket("Ticket Test");
    ticket.setAuthorId(112L);
    ticket.setAuthorName("AuthorName");
    ticket.setDescription("Description");
    ticket.setName("Name");

    assertThat(ticket.getAuthorId(), is(112L));
    assertThat(ticket.getAuthorName(), is("AuthorName"));
    assertThat(ticket.getDescription(), is("Description"));
    assertThat(ticket.getName(), is("Name"));
  }

}
