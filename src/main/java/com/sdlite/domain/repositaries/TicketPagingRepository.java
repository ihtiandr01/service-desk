package com.sdlite.domain.repositaries;


import com.sdlite.domain.entities.Ticket;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TicketPagingRepository extends PagingAndSortingRepository<Ticket, Long> {


}
