package com.sdlite.domain;

import com.sdlite.domain.entities.Ticket;
import com.sdlite.domain.repositaries.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Component
public class TicketHelper {

  @Autowired
  private TicketRepository ticketRepository;

  public Iterable<Ticket> findByLikeName(final String query) {
    Specification spec = new Specification<Ticket>() {
      @Override
      public Predicate toPredicate(Root<Ticket> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("name"), query + "%");
      }
    };
    return ticketRepository.findAll(spec);
  }
}
