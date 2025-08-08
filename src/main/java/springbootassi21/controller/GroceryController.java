package springbootassi21.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/grocery")
public class GroceryController {

    @GetMapping("/public")
    public String welcome() {
        return "Welcome to the Grocery Store!";
    }

    @GetMapping("/items")
    public List<String> getItems() {
        return Arrays.asList("Apples", "Bananas", "Carrots");
    }

    @GetMapping("/orders")
    public List<String> getOrders() {
        return Arrays.asList("Order1", "Order2", "Order3");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminOnly() {
        return "Admin-only information";
    }
}
