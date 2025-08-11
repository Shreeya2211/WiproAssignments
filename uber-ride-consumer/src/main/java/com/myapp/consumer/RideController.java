package com.myapp.consumer;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rides")
public class RideController 
{

    private final RideService rideService;

    public RideController(RideService rideService)
    {
        this.rideService = rideService;
    }

    @GetMapping
    public List<Ride> getAllRides()
    {
        return rideService.getAllRides();
    }

    @GetMapping("/{id}")
    public Optional<Ride> getRideById(@PathVariable Long id)
    {
        return rideService.getRideById(id);
    }
}