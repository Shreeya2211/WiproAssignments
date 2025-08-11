package com.myapp.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rides")
public class ProducerController
{

    private final ProducerService producerService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public ProducerController(ProducerService producerService)
    {
        this.producerService = producerService;
    }

    @PostMapping
    public String createRide(@RequestBody Map<String, Object> rideMap) throws JsonProcessingException
    {
        rideMap.put("operation", "CREATE");
        String json = objectMapper.writeValueAsString(rideMap);
        producerService.sendMessage(json);
        return "Ride created and sent to Kafka";
    }

    @PutMapping("/{id}")
    public String updateRide(@PathVariable Long id, @RequestBody Map<String, Object> rideMap) throws JsonProcessingException
    {
        rideMap.put("operation", "UPDATE");
        rideMap.put("id", id);
        String json = objectMapper.writeValueAsString(rideMap);
        producerService.sendMessage(json);
        return "Ride updated and sent to Kafka";
    }

    @DeleteMapping("/{id}")
    public String deleteRide(@PathVariable Long id) throws JsonProcessingException
    {
        Map<String, Object> map = new HashMap<>();
        map.put("operation", "DELETE");
        map.put("id", id);
        String json = objectMapper.writeValueAsString(map);
        producerService.sendMessage(json);
        return "Ride deletion sent to Kafka";
    }

    @GetMapping("/{id}")
    public String getRide(@PathVariable Long id)
    {
        return "GET operation is handled by Consumer service";
    }
}