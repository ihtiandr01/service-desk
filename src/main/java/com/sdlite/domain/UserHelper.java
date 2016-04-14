package com.sdlite.domain;

import com.sdlite.domain.entities.User;
import com.sdlite.domain.repositaries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

@Component
public class UserHelper {

  @Autowired
  private UserRepository userRepository;

  public Iterable<User> findByLikeName(final String query) {
    Specification spec = new Specification<User>() {
      @Override
      public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.like(root.get("name"), query + "%");
      }
    };
    return userRepository.findAll(spec);
  }

}
