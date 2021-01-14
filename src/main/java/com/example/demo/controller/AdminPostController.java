package com.example.demo.controller;

import com.example.demo.entity.Account;
import com.example.demo.entity.Post;
import com.example.demo.service.AccountService;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
//@RequestMapping("/admin/account")
public class AdminPostController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
