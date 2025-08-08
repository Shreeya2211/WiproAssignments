package com.springboot22.orderservice;

import org.springframework.stereotype.Service;

@Service
public class OrderService {
    public Order getOrderById(Long id) {
        return new Order(id, "KFC", 3);
    }
}