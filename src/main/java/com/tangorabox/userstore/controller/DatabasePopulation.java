package com.tangorabox.userstore.controller;

import com.tangorabox.userstore.entity.User;
import com.tangorabox.userstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;

@Controller
public class DatabasePopulation implements CommandLineRunner {

    private static final LocalDate BIRTH_DATE = LocalDate.of(1990, 1, 1);
    private static final String[] USER_NAMES = new String[]{"Jack", "Chloe", "Jhonn", "Paul", "Maria", "Alex"};

    private final UserRepository userRepository;

    @Autowired
    public DatabasePopulation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) {
        for (int i = 0; i < USER_NAMES.length; i++) {
            userRepository.save(createUser(i));
        }
    }

    private User createUser(int index) {
        User user = new User();
        user.setName(USER_NAMES[index]);
        user.setBirthdate(BIRTH_DATE.plusDays(index).plusMonths(index).plusYears(index));
        return user;
    }
}
