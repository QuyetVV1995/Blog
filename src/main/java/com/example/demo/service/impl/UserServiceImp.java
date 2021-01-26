package com.example.demo.service.impl;


import com.example.demo.model.Post;
import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.dto.UserDto;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private static final String USER_ROLE = "ROLE_USER";

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User save(UserDto userDto) {
        User user =  new User( userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()), userDto.getUsername(), true);
        user.setRoles(Collections.singleton(roleRepository.findByRole(USER_ROLE)));
        return userRepository.saveAndFlush(user);
    }

}
