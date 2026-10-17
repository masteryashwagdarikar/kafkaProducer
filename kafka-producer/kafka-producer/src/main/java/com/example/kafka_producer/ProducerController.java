package com.example.kafka_producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProducerController {

	@Autowired
    private KafkaProducerService producerService;

    // Example URL: http://localhost:8080/publish?message=HelloKafkaWorld
    @GetMapping("/publish")
    public String publishMessage(@RequestParam("message") String message) {
        producerService.sendMessage(message);
        return "Message published successfully to Kafka topic: " + message;
    }
}
