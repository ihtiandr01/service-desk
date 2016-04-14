package com.sdlite.security;

import com.sdlite.domain.entities.User;
import com.sdlite.domain.repositaries.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class SDUserDetailsService implements UserDetailsService {
  private static final Logger LOGGER = LoggerFactory.getLogger(SDUserDetailsService.class);
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findOneByLogin(username);
    if (user != null) {
      return new UserDetails() {
        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
          List<SimpleGrantedAuthority> auths = new ArrayList<SimpleGrantedAuthority>();
          auths.add(new SimpleGrantedAuthority(user.getRole()));
          return auths;
        }

        @Override
        public String getPassword() {
          return user.getPassword();
        }

        @Override
        public String getUsername() {
          return user.getLogin();
        }

        @Override
        public boolean isAccountNonExpired() {
          return true;
        }

        @Override
        public boolean isAccountNonLocked() {
          return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
          return true;
        }

        @Override
        public boolean isEnabled() {
          return true;
        }
      };

    }
    LOGGER.debug("User not found");
    throw new UsernameNotFoundException("User " + username + " not found");

  }
}
