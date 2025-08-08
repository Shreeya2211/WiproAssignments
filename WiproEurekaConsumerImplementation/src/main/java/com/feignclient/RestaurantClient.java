package com.feignclient;

import com.pojos.Restaurant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "WiproEurekaProducerImplementation")
public interface RestaurantClient {

    @GetMapping("/restaurants")
    List<Restaurant> getAllRestaurants();
}
