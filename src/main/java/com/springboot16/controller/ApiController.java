package com.springboot16.controller;

import com.springboot16.model.Post;
import com.springboot16.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class ApiController {

    @Autowired
    private ApiService apiService;

    // GET all posts
    @GetMapping
    public List<Post> getAll() {
        return apiService.getAllPosts();
    }

    // GET post by ID
    @GetMapping("/{id}")
    public Post getById(@PathVariable int id) {
        return apiService.getPostById(id);
    }

    // POST create new post
    @PostMapping
    public Post create(@RequestBody Post post) {
        return apiService.createPost(post);
    }

    // PUT update post
    @PutMapping("/{id}")
    public Post update(@PathVariable int id, @RequestBody Post post) {
        return apiService.updatePost(id, post);
    }

    // DELETE post
    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return apiService.deletePost(id);
    }
}
