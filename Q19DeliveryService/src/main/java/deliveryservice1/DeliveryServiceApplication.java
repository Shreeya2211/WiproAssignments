package deliveryservice1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DeliveryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryServiceApplication.class, args);
    }
}

@RestController
class DeliveryController {
    @GetMapping("/delivery/status")
    public String getStatus() {
        return "Delivery is on time";
    }
}


//http://localhost:8081/delivery/status
//Delivery is on time