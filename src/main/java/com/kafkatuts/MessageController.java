package com.kafkatuts;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final KafkaMessagePublisher kafkaMessagePublisher;

    public MessageController(KafkaMessagePublisher kafkaMessagePublisher) {
        this.kafkaMessagePublisher = kafkaMessagePublisher;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam(name = "msg", defaultValue = "Hello Kafka") String message) {
        kafkaMessagePublisher.sendMessage(message);
        return ResponseEntity.ok("Message sent to topic");
    }
}
