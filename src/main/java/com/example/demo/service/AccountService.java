package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.model.dto.AccountRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AccountService {

    public List<Account> getAllAccount();

}
