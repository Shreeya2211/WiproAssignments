package com.springboot.paymentservice;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    public Payment getPayment(Long id) {
        return new Payment(id, 400, "COMPLETED");
    }
}