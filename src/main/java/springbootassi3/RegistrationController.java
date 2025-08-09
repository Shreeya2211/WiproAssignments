package springbootassi3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showForm() {
        // This will serve the register.html from static folder
        return "register.html";
    }

    @PostMapping("/register")
    @ResponseBody
    public String processForm(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String email,
            @RequestParam String birthday,
            @RequestParam String profession) {

        return "<h2>Registration Successful</h2>"
                + "<p><b>User Name:</b> " + username + "</p>"
                + "<p><b>Password:</b> " + password + "</p>"
                + "<p><b>Email:</b> " + email + "</p>"
                + "<p><b>Birthday:</b> " + birthday + "</p>"
                + "<p><b>Profession:</b> " + profession + "</p>";
    }
}
