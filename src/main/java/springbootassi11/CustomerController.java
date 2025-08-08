package springbootassi11;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/springrest")
public class CustomerController 
{

    @GetMapping("/customers")
    public List<Customer> getCustomers()
    {
        List<Customer> list = new ArrayList<>();

        Customer c1 = new Customer();
        c1.setId(101);
        c1.setFirstName("Virat");
        c1.setLastName("Kohli");
        c1.setEmail("viratkohli@gmail.com");
        c1.setMobile("121-232-3435");
        c1.setDateOfBirth(1467240235069L);

        list.add(c1);
        return list;
    }
}
