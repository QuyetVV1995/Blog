package com.example.demo.controller;

import com.example.demo.model.dto.AccountRegistrationDto;
import com.example.demo.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class AccountController {
    private AccountService accountService;


    @ModelAttribute("/registration/account")
    public AccountRegistrationDto userRegistrationDto() {
        return new AccountRegistrationDto();
    }

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") AccountRegistrationDto registrationDto) {
        accountService.saveAccountRegistor(registrationDto);
        return "redirect:/registration?success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
