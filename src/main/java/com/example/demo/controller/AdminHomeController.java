package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {
    @Autowired
    private AccountService accountService;

    @GetMapping()
    public String getAllAccount(Model model){
        List<Account> list = accountService.getAllAccount();
        model.addAttribute("listAccount", list);
        return "admin/listAccount";
    }
}
