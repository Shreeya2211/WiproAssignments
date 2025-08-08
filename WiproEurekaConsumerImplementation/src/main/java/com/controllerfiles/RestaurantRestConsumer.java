package com.controllerfiles;

import com.feignclient.RestaurantClient;
import com.pojos.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/consumer/restaurants")
public class RestaurantRestConsumer {

    @Autowired
    private RestaurantClient restaurantClient;

    @GetMapping
    public List<Restaurant> getRestaurantsViaFeign() {
        return restaurantClient.getAllRestaurants();
    }
}
