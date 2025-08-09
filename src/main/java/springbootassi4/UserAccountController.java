package springbootassi4;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserAccountController {

    @GetMapping("/users/{id}/accounts")
    public String getAccounts(
            @PathVariable String id,
            @RequestParam String type,
            @RequestParam String status) {

        return "User ID: " + id +
               "<br>Account Type: " + type +
               "<br>Status: " + status;
    }
}
/*
http://localhost:8080/users/101/accounts?type=current&status=active
*/