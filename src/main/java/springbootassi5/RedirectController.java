package springbootassi5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/example")
public class RedirectController {

    @GetMapping("/test2")
    public String test2() {
        return "This is the test2 page!";
    }
}
