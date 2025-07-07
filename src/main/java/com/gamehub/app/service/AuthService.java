package com.gamehub.app.service;

public interface AuthService {
    boolean authenticate(String username, String password);
    boolean register(String username, String password);
}
