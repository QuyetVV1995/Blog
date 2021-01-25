package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String getAllPost(Model model){
        List<Post> postList = postService.getALlPost();
        model.addAttribute("postList", postList);
        return "homepage";
    }

    @GetMapping("/newPost")
    public String newPost(Principal principal, Model model){        // Principal la gi????
        Optional<User> user = userService.findByUsername(principal.getName());
        if(user.isPresent()){
            Post post = new Post();
            post.setUser(user.get());
            model.addAttribute("post", post);
            return "postForm";
        }
        else
        {
            return "error";
        }
    }

    @PostMapping("/newPost")
    public String createNewPost(@Valid Post post, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "postForm";
        }
        else{
            postService.save(post);
            return "redirect:/homepage";
        }
    }
}
