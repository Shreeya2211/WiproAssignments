package com.springboot16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Springboot16Application {
    public static void main(String[] args) {
        SpringApplication.run(Springboot16Application.class, args);
    }
}
/*
get http://localhost:8080/api/posts
GET http://localhost:8080/api/posts/1
{
"userId": 1,
"title": "Spring Boot Demo Post",
"body": "This is a test post via Postman"
}
*/