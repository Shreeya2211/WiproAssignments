package springbootassi10.Controller;

import springbootassi10.model.Customer;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RestController // Important: makes it return plain text or JSON
@RequestMapping("/cust")
public class CustomerController {

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute @Valid Customer customer, BindingResult result) {
        if (result.hasErrors()) {
            return "Validation failed: " + result.getAllErrors().toString();
        }
        // You can save the customer here using a service/repo
        return "Customer saved successfully!";
    }
}
