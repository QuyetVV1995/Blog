package com.example.demo.service;

import com.example.demo.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public interface AccountService {

    Optional<Account> findByEmail(String email);

    public List<Account> getAllAccount();

    Account save(Account account);

}
