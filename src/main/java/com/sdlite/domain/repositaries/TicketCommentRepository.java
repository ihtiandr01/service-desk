package com.sdlite.domain.repositaries;

import com.sdlite.domain.entities.TicketComment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketCommentRepository extends CrudRepository<TicketComment, Long> {
  List<TicketComment> findByTicketId(Long ticketId);
}
