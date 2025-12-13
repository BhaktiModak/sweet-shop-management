package com.sweetshop.config;

import com.sweetshop.entities.User;
import com.sweetshop.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    private final UserService userService;

    public TestRunner(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String... args) {
        String email = "bhaktim@1234";
        if (userService.findByEmail(email) == null) {
            User user = new User();
            user.setName("Bhakti");
            user.setEmail(email);
            user.setPassword("1234"); // will be encoded
            userService.registerUser(user);
            System.out.println("Test user created: " + email);
        }
    }
}
