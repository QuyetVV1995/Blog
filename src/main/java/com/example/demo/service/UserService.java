package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.dto.UserDto;


import java.util.Optional;

public interface UserService  {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    User save(UserDto userDto);
}
