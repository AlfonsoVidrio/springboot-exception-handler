package com.alfonsovidrio.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alfonsovidrio.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {

    @Bean
    List<User> users() {
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Alfonso", "Vidrio"));
        users.add(new User(2L,"Bob", "Sponge"));
        users.add(new User(3L, "Jane", "Doe"));
        users.add(new User(4L, "Michael", "Jackson"));
        users.add(new User(5L, "Alice", "Wonderland"));
        return users;
    }
}
