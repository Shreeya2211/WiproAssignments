package com.myapp.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerListener
{

    private static final Logger logger = LoggerFactory.getLogger(ConsumerListener.class);

    private final RideRepository rideRepository;
    private final ObjectMapper objectMapper;

    public ConsumerListener(RideRepository rideRepository)
    {
        this.rideRepository = rideRepository;
        this.objectMapper = new ObjectMapper();
    }

    @KafkaListener(topics = "uber-ride-topic", groupId = "uber_ride_group")
    public void consume(String message)
    {
        try
        {
            RideEvent event = objectMapper.readValue(message, RideEvent.class);

            Ride ride = new Ride();
            ride.setId(event.getId());
            ride.setDriverName(event.getDriverName());
            ride.setPassengerName(event.getPassengerName());
            ride.setPickupLocation(event.getPickupLocation());
            ride.setDropLocation(event.getDropLocation());
            ride.setFare(event.getFare());

            switch (event.getOperation().toUpperCase())
            {
                case "CREATE":
                case "UPDATE":
                    rideRepository.save(ride);
                    logger.info("{}d ride with id: {}", event.getOperation(), ride.getId());
                    break;
                case "DELETE":
                    rideRepository.deleteById(event.getId());
                    logger.info("Deleted ride with id: {}", event.getId());
                    break;
                default:
                    logger.error("Unknown operation: {}", event.getOperation());
            }
        } catch (Exception e) {
            logger.error("Error processing message: {}", message, e);
        }
    }
}