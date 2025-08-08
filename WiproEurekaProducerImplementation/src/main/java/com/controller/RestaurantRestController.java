package com.controller;

import com.pojos.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

@RestController
public class RestaurantRestController {

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurants() {
        return Arrays.asList(
            new Restaurant(1, "Pizza Hut"),
            new Restaurant(2, "Dominos"),
            new Restaurant(3, "Burger King")
        );
    }
}
