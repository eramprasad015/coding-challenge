package com;

import com.entity.Name;
import com.entity.User;
import com.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadData {

  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {
    return args -> {
        User user = new User();
        user.setGender("male");
        Name name = new Name();
        name.setLast("Arnette");
        name.setFirst("Bascomb");
        user.setName(name);
      log.info("Preloading " + repository.save(user));
    };
  }
}