package springbootassi6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExampleController {

    @GetMapping("/example/test2")
    public String test2() {
        return "test2"; // loads test2.jsp
    }
}
