package com.springboot16.service;

import com.springboot16.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ApiService {

    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/posts";

    @Autowired
    private RestTemplate restTemplate;

    // GET all posts
    public List<Post> getAllPosts() {
        try {
            ResponseEntity<Post[]> response = restTemplate.getForEntity(BASE_URL, Post[].class);
            return Arrays.asList(response.getBody());
        } catch (RestClientException e) {
            System.out.println("Error fetching posts: " + e.getMessage());
            return List.of();
        }
    }

    // GET post by ID
    public Post getPostById(int id) {
        try {
            return restTemplate.getForObject(BASE_URL + "/" + id, Post.class);
        } catch (RestClientException e) {
            System.out.println("Error fetching post by ID: " + e.getMessage());
            return null;
        }
    }

    // POST create a new post
    public Post createPost(Post post) {
        try {
            return restTemplate.postForObject(BASE_URL, post, Post.class);
        } catch (RestClientException e) {
            System.out.println("Error creating post: " + e.getMessage());
            return null;
        }
    }

    // PUT update an existing post
    public Post updatePost(int id, Post post) {
        try {
            HttpEntity<Post> entity = new HttpEntity<>(post);
            ResponseEntity<Post> response = restTemplate.exchange(
                    BASE_URL + "/" + id, HttpMethod.PUT, entity, Post.class);
            return response.getBody();
        } catch (RestClientException e) {
            System.out.println("Error updating post: " + e.getMessage());
            return null;
        }
    }

    // DELETE a post
    public String deletePost(int id) {
        try {
            restTemplate.delete(BASE_URL + "/" + id);
            return "Post deleted with ID: " + id;
        } catch (RestClientException e) {
            return "Error deleting post: " + e.getMessage();
        }
    }
}
