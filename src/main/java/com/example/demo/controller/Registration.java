package com.example.demo.controller;

import com.example.demo.model.dto.AccountRegistrationDto;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class Registration {
    @Autowired
    private AccountService accountService;

    @ModelAttribute("account")
    public AccountRegistrationDto userRegistrationDto() {
        return new AccountRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("account") AccountRegistrationDto registrationDto) {
        accountService.save(registrationDto);
        return "redirect:/registration?success";
    }


}
