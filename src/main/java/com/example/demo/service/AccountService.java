package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.model.dto.AccountRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService extends UserDetailsService {

    public Account save(AccountRegistrationDto accountRegistrationDto);
}
