package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/home")
    public String getAllPost(Model model){
        List<Post> postList = postService.getAllPost();
        System.out.println("-----");
        System.out.println(postList.get(0).getCreated_at());
        model.addAttribute("postList", postList);
        return "homePage";
    }
}
