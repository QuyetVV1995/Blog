package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);
}
