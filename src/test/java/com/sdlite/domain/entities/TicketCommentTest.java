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
public class TicketCommentTest {

  @Test
  public void testTicketComment() {
    TicketComment ticketComment = new TicketComment();
    ticketComment.setAuthorId(112L);
    ticketComment.setAuthorName("Author Name");
    ticketComment.setComment("Comment comment");
    ticketComment.setTicketId(1L);

    assertThat(ticketComment.getAuthorId(), is(112L));
    assertThat(ticketComment.getAuthorName(), is("Author Name"));
    assertThat(ticketComment.getComment(), is("Comment comment"));
    assertThat(ticketComment.getTicketId(), is(1L));
  }

}
