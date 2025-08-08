package springbootassi14.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootassi14.entity.Food;
import springbootassi14.entity.Restaurant;
import springbootassi14.service.RestaurantService;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController 
{

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping
    public Restaurant createRestaurant(@Valid @RequestBody Restaurant restaurant) 
    {
        return restaurantService.createRestaurant(restaurant);
    }

    @GetMapping
    public List<Restaurant> getAllRestaurants() 
    {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/{id}")
    public Restaurant getRestaurantById(@PathVariable Long id)
    {
        return restaurantService.getRestaurantById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteRestaurant(@PathVariable Long id) 
    {
        restaurantService.deleteRestaurant(id);
    }

    @PostMapping("/{id}/foods")
    public Food addFoodToRestaurant(@PathVariable Long id, @Valid @RequestBody Food food)
    {
        return restaurantService.addFoodToRestaurant(id, food);
    }

    @DeleteMapping("/foods/{foodId}")
    public void deleteFood(@PathVariable Long foodId) 
    {
        restaurantService.deleteFood(foodId);
    }
}
