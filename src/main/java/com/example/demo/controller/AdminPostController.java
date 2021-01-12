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
@RequestMapping("/admin/account")
public class AdminPostController {
    @Autowired
    private AccountService accountService;

    @GetMapping("/list")
    public String getAllAccount(Model model){
        List<Account> accountList = accountService.getAllAccount();
        model.addAttribute("accountList", accountList);
        return "admin/listAccount";
    }

    @GetMapping("/add")
    public String createAccount(Model model) {
        model.addAttribute("account", new Account());
        return "admin/formAccount";
    }

    @PostMapping("/save")
    public String saveAccount(@ModelAttribute("account") Account account){
        accountService.save(account);
        return "redirect:/admin/account/list";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editAccount(@PathVariable(name = "id") int id){
        ModelAndView mav = new ModelAndView("admin/editAccount");
        Account account = accountService.edit(id);
        mav.addObject("editAccount", account);
        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id") long id){
        accountService.deleteAccount(id);
        return "redirect:/admin/account/list";
    }

    @GetMapping("/search/{username}")
    public ModelAndView findByUsername(@PathVariable(name = "username") String username){
        ModelAndView mav = new ModelAndView("admin/searchByUsername");
        Account accounts = accountService.findByUsername(username);
        System.out.println(accounts.getUsername());
        mav.addObject("searchByUsername",accounts);
        return mav;
    }
}
