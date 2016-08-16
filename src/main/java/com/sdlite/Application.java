package com.sdlite;

import com.sdlite.configuration.ConfigurationStorage;
import com.sdlite.domain.entities.*;
import com.sdlite.domain.entities.builders.TicketBuilder;
import com.sdlite.domain.entities.builders.UserBuilder;
import com.sdlite.domain.repositaries.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class Application implements CommandLineRunner {

  private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

  @Autowired
  TicketRepository repository;

  @Autowired
  TicketPagingRepository ticketPagingRepository;

  @Autowired
  UserRepository userRepository;

  @Autowired
  InventoryPagingRepository inventoryRepository;

  @Autowired
  SettingsRepository settingsRepository;

  @Autowired
  ConfigurationStorage configurationStorage;

  @Autowired
  TimeTrackerRecordRepository timeRecordRepository;


  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {

    /*************************************
     TEST DATA START
     **************************************/

    for (int i = 0; i < 15; i++) {
      Ticket ticket = TicketBuilder.newInstance()
              .setAssignName("User 1")
              .setName("Ticket#" + i)
              .setPriority("Normal")
              .build();
      repository.save(ticket);
    }

    for (int i = 0; i < 15; i++) {
      inventoryRepository.save(new InventoryItem("InventoryItem#" + i));
    }
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

    ConfigurationItem dateItem = new ConfigurationItem("sd.confitem.date_time_mask", "dd-MM-yyyy HH:mm");
    settingsRepository.save(dateItem);


    TimeTrackerRecord timeRecord1 = new TimeTrackerRecord("Задача 1");
    timeRecordRepository.save(timeRecord1);

    /*************************************
     TEST DATA END
     **************************************/
  }

}
