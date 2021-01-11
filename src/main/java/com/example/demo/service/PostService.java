package com.example.demo.service;

import com.example.demo.entity.Post;
import com.example.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {

    public List<Post> getAllPost();

    public void save(Post post);

    public Post edit(long id);

    public void deletePost(long id);

    public List<Post> findByTitle(String title);

}
