package springbootassi13.controller;



import springbootassi13.entity.User;

import springbootassi13.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;



import java.util.*;



@RestController

@RequestMapping("/api/user")

public class UserController {



    @Autowired

    private UserService userService;



    @GetMapping("/")

    public List<User> getAllUsers() {

        return userService.getAllUsers();

    }



    @GetMapping("/{id}")

    public ResponseEntity<?> getUserById(@PathVariable Long id) {

        return userService.getUserById(id)

                .<ResponseEntity<?>>map(ResponseEntity::ok)

                .orElse(ResponseEntity.status(404).body(Map.of("errorMessage", "User with id " + id + " not found")));

    }



    @PostMapping("/")

    public User createUser(@RequestBody User user) {

        return userService.createUser(user);

    }



    @PutMapping("/{id}")

    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User userDetails) {

        return userService.updateUser(id, userDetails)

                .<ResponseEntity<?>>map(ResponseEntity::ok)

                .orElse(ResponseEntity.status(404).body(Map.of("errorMessage", "User with id " + id + " not found")));

    }



    @DeleteMapping("/{id}")

    public ResponseEntity<?> deleteUser(@PathVariable Long id) {

        Boolean deleted = userService.deleteUser(id);

        if (deleted) {

            return ResponseEntity.ok().build();

        } else {

            return ResponseEntity.status(404).body(Map.of("errorMessage", "User with id " + id + " not found"));

        }

    }

}