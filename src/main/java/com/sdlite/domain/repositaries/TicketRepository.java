package com.sdlite.domain.repositaries;

import com.sdlite.domain.entities.Ticket;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long>, JpaSpecificationExecutor<Ticket> {
    List<Ticket> findByName(String name);
    List<Ticket> findByStatus(String status);
    List<Ticket> findByAuthorName(String author);
    List<Ticket> findByAssignName(String assignName);
    List<Ticket> findByAssignId(long assignId);
}
