package com.sdlite.domain.repositaries;

import com.sdlite.Application;
import com.sdlite.domain.entities.TicketComment;
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
public class TicketCommentRepositoryTest {

    @Autowired
    TicketCommentRepository ticketCommentRepository;

    @Test
    public void testTicketRepository() {
        long id = ticketCommentRepository.save(new TicketComment(1L,"Comment","author name",2L)).getId();
        TicketComment ticketComment = ticketCommentRepository.findOne(id);
        assertThat(ticketComment.getTicketId(),is(1L));
        assertThat(ticketComment.getComment(),is("Comment"));
        assertThat(ticketComment.getAuthorName(),is("author name"));
        assertThat(ticketComment.getAuthorId(),is(2L));
    }
}
