package com.example.demo.service;

import com.example.demo.model.Post;
import com.example.demo.model.User;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface PostService {

    List<Post> getALlPost();

    Post save(Post post);
}
