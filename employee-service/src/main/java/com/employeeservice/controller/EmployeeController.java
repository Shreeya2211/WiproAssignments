package com.employeeservice.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/employee/test")
    public String test(@RequestHeader(value = "X-Gateway-Header", required = false) String gatewayHeader) {
        return " Employee Service is Working! Received Header: " + gatewayHeader;
    }
}