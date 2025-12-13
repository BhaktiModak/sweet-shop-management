package com.sweetshop.services;

import com.sweetshop.entities.User;

public interface UserService {
    User registerUser(User user);
    User findByEmail(String email);
}
