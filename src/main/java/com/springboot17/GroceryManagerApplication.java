package com.springboot17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:app-config.properties", "classpath:custom-validation.properties"})
public class GroceryManagerApplication 
{
    public static void main(String[] args) 
    {
        SpringApplication.run(GroceryManagerApplication.class, args);
    }
}
