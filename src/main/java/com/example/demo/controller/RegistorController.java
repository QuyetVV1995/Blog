package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistorController {
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/registration")
    public String registration(Model model){
        model.addAttribute("account", new Account());
        return "registration";
    }

    @PostMapping(value = "/registration" )
    public String createNewAccount(@ModelAttribute("account") Account account, BindingResult bindingResult, Model model){
        if(accountService.findByEmail(account.getEmail()).isPresent()){
            bindingResult.rejectValue("email", "error.user",
                    "There is already a user registered with the email provided");
        }
        if(!bindingResult.hasErrors()){
            accountService.save(account);
            model.addAttribute("successMessage", "User has been registered successfully");
            model.addAttribute("account", new Account());
        }
        return "registration";
    }
}
