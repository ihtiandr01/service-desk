package com.sdlite.domain.repositaries;

import com.sdlite.domain.entities.Ticket;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Long>, JpaSpecificationExecutor<Ticket> {
    List<Ticket> findByName(String name);
}
