package com.mainfiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
        "com.controllerfiles",
        "com.feignclient",
        "com.pojos"
})
@EnableFeignClients(basePackages = "com.feignclient")
@EnableDiscoveryClient
public class WiproEurekaConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WiproEurekaConsumerApplication.class, args);
    }
}
