package circuitbreaker.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DeliveryStatusController {

    private final RestTemplate restTemplate;
    private static final String BASE_URL = "http://localhost:8081/delivery/status";
    private static final String CIRCUIT_NAME = "deliveryService";

    public DeliveryStatusController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/delivery/status")
    @CircuitBreaker(name = CIRCUIT_NAME, fallbackMethod = "fallbackDeliveryStatus")
    public String getDeliveryStatus() {
        return restTemplate.getForObject(BASE_URL, String.class);
    }

    public String fallbackDeliveryStatus(Throwable t) {
        return "Delivery service is currently unavailable. Please try again later.";
    }
}