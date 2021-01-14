package com.example.demo.controller;

import com.example.demo.entity.Post;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/add")
    public String createPost(Model model) {
        model.addAttribute("post", new Post());
        return "admin/formPost";
    }

    @PostMapping("/save")
    public String savePost(@ModelAttribute("post") Post post){
        postService.save(post);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editPost(Model model,@PathVariable(name = "id") int id){
        Post post = postService.edit(id);
        model.addAttribute("editPost", post);
        return "admin/editPost";
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable(name = "id") long id){
        postService.deletePost(id);
        return "redirect:/";
    }

    @GetMapping("/search/{title}")
    public ModelAndView findByTitle(@PathVariable(name = "title") String title){
        ModelAndView mav = new ModelAndView("searchByTitle");
        List<Post> post = postService.findByTitle(title);
        mav.addObject("searchByTitle",post);
        return mav;
    }

}
