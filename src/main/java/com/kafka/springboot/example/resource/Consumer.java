package com.kafka.springboot.example.resource;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    private static final String TOPIC = "Kafka_Example";

    @KafkaListener(topics = TOPIC,group = "test")
    public void consume(String message) {
        System.out.println(
                String.format("$$$ -> Consumed Message -> %s", message));
    }

}
