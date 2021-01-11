package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/home")
    public String getAllPost(Model model){
        List<Post> postList = postService.getAllPost();
        model.addAttribute("postList", postList);
        return "homePage";
    }

    @GetMapping("/add")
    public String createPost(Model model) {
        model.addAttribute("post", new Post());
        return "form";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post){
        postService.save(post);
        return "redirect:/home";
    }

}