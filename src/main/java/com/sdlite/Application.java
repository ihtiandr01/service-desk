package com.sdlite;

import com.sdlite.domain.entities.Ticket;
import com.sdlite.domain.entities.User;
import com.sdlite.domain.entities.builders.UserBuilder;
import com.sdlite.domain.repositaries.TicketRepository;
import com.sdlite.domain.repositaries.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
public class Application implements CommandLineRunner {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    
    @Autowired
    TicketRepository repository;
    
    @Autowired
    UserRepository userRepository;
    

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        repository.save(new Ticket("Ticket1"));
        repository.save(new Ticket("Ticket2"));
        repository.save(new Ticket("Ticket3"));


        User admin = UserBuilder.newInstance()
                .setLogin("admin")
                .setName("Administrator")
                .setPassword("123")
                .setEmail("admin@mail.com")
                .setRole("ADMIN").build();

        User user1 = UserBuilder.newInstance()
                .setLogin("user1")
                .setName("User 1")
                .setPassword("123")
                .setEmail("user1@mail.com")
                .setRole("USER").build();

        User user2 = UserBuilder.newInstance()
                .setName("User 2")
                .setLogin("user2")
                .setPassword("123")
                .setEmail("user2@mail.com")
                .setRole("USER").build();

        User user3 = UserBuilder.newInstance()
                .setName("User 3")
                .setLogin("user3")
                .setPassword("123")
                .setEmail("user3@mail.com")
                .setRole("USER").build();

        userRepository.save(admin);
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        
    }

}
