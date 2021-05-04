package com.kafka.springboot.example.resource;

import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.springboot.example.model.User;

@RestController
@RequestMapping("kafka")
public class Publisher {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "Kafka_Example";

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {
        IntStream stream = IntStream.range(1, 1000000);
        stream.forEach(i -> kafkaTemplate.send(TOPIC,
                new User(name + i, "Technology", 12000L)));

        return "Published successfully";
    }
}
