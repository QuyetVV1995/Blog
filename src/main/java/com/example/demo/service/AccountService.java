package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    public List<Account> getAllAccount();

    public void save(Account account);

    public Account edit(long id);

    public void deleteAccount(long id);

    public Account findByUsername(String username);
}
