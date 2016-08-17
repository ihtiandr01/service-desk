package com.sdlite.security;

import com.sdlite.domain.entities.User;
import com.sdlite.domain.repositaries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public class SecurityHelper {

  public static String getCurrentUsername() {
    Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    if (principal instanceof UserDetails) {
      return ((UserDetails) principal).getUsername();
    } else {
      return principal.toString();
    }
  }

  public static long getCurrentUserId(UserRepository userRepository) {
    User user = userRepository.findOneByLogin(getCurrentUsername());
    if(user == null) return 0L;
    return user.getId();
  }

}
