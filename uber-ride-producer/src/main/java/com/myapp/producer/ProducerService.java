package com.myapp.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProducerService
{

    private final KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "uber-ride-topic";

    public ProducerService(KafkaTemplate<String, String> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message)
    {
        kafkaTemplate.send(TOPIC, message);
    }
}