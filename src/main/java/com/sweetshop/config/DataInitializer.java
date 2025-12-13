package com.sweetshop.config;

import com.sweetshop.entities.Role;
import com.sweetshop.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;

    public DataInitializer(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        if (roleRepository.findByName("USER") == null) {
            Role role = new Role();
            role.setName("USER");
            roleRepository.save(role);
            System.out.println("ROLE USER CREATED");
        }
    }
}
