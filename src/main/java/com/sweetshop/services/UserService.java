package com.sweetshop.services;

import com.sweetshop.entities.User;

public interface UserService {
    User registerUser(User user);      // register new user
    User findByEmail(String email);    // find user by email
}
