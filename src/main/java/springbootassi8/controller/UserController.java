package springbootassi8.controller;

import org.springframework.web.bind.annotation.*;
import springbootassi8.model.User;

@RestController
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public String createUser(@RequestBody User user) {
        return "User created: " + user.getFirstName() + " " + user.getLastName() +
               ", Age: " + user.getAge();
    }
}
