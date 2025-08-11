package com.myapp.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(ProducerApplication.class, args);
    }
}
////http://localhost:8081/rides   ---post
//Ride created and sent to Kafka