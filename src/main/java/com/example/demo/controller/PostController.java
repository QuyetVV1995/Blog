package com.example.demo.controller;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import com.example.demo.service.PostService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Optional;

@Controller
public class PostController {

    @Autowired
    private  PostService postService;
    @Autowired
    private  UserService userService;

    @GetMapping(value = "/newPost")
    public String newPost(Principal principal,
                          Model model) {

        Optional<User> user = userService.findByUsername(principal.getName());

        if (user.isPresent()) {
            Post post = new Post();
            post.setUser(user.get());

            model.addAttribute("post", post);

            return "/postForm";

        } else {
            return "/error";
        }
    }

    @PostMapping(value = "/newPost")
    public String createNewPost(@Valid Post post,
                                BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "/postForm";
        } else {
            postService.save(post);
            return "redirect:/blog/" + post.getUser().getUsername();
        }
    }

    @GetMapping(value = "/editPost/{id}")
    public String editPostWithId(@PathVariable Long id,
                                 Principal principal,
                                 Model model) {

        Optional<Post> optionalPost = postService.findForId(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            if (isPrincipalOwnerOfPost(principal, post)) {
                model.addAttribute("post", post);
                return "/postForm";
            } else {
                return "/403";
            }

        } else {
            return "/error";
        }
    }

    @GetMapping(value = "/post/{id}")
    public String getPostWithId(@PathVariable Long id,
                                Principal principal,
                                Model model) {

        Optional<Post> optionalPost = postService.findForId(id);


        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            model.addAttribute("post", post);
            if (isPrincipalOwnerOfPost(principal, post)) {
                model.addAttribute("username", principal.getName());
            }

            return "/post";

        } else {
            return "/error";
        }
    }

    @DeleteMapping(value = "/post/{id}")
    public String deletePostWithId(@PathVariable Long id,
                                   Principal principal) {

        Optional<Post> optionalPost = postService.findForId(id);

        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();

            if (isPrincipalOwnerOfPost(principal, post)) {
                postService.delete(post);
                return "redirect:/home";
            } else {
                return "/403";
            }

        } else {
            return "/error";
        }
    }

    private boolean isPrincipalOwnerOfPost(Principal principal, Post post) {
        return principal != null && principal.getName().equals(post.getUser().getUsername());
    }

    @GetMapping(value = "post/detail/{id}")
    public String PostDetail(@PathVariable long id,Principal principal, Model model){
        Optional<Post> optionalPost = postService.findForId(id);
        if (optionalPost.isPresent()) {
            Post post = optionalPost.get();
            model.addAttribute("post", post);
            String name = post.getName();
            if (isPrincipalOwnerOfPost(principal, post)) {
                model.addAttribute("username", principal.getName());
            }
            return "/Japaneses/" + name;
        } else {
            return "/error";
        }
    }
}
