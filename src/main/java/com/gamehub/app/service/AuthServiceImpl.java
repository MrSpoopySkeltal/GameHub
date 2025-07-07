package com.gamehub.app.service;

import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public boolean authenticate(String username, String password) {
        return "admin".equals(username) && "password".equals(password);
    }

    @Override
    public boolean register(String username, String password) {
        // You can add fake logic here, like:
        return !"existingUser".equals(username); // simulate a duplicate user fail
    }
}
