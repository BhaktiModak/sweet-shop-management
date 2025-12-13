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
    public void run(String... args) throws Exception {
        if (userService.findByEmail("bhaktim@1234") == null) {
            User user = new User();
            user.setName("Bhakti");
            user.setUsername("bhakti123");
            user.setEmail("bhaktim@1234");
            user.setPassword("1234");
            userService.registerUser(user);
        }
    }
    

}