package com.sdlite.domain.repositaries;

import com.sdlite.domain.entities.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long>, JpaSpecificationExecutor<User> {
    List<User> findByName(String name);
    User findOneByLogin(String name);
}
