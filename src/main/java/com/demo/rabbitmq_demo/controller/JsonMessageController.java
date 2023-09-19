package com.demo.rabbitmq_demo.controller;

import com.demo.rabbitmq_demo.dto.User;
import com.demo.rabbitmq_demo.publisher.RabbitMQJsonPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class JsonMessageController {

    private final RabbitMQJsonPublisher jsonPublisher;

    public JsonMessageController(RabbitMQJsonPublisher jsonPublisher) {
        this.jsonPublisher = jsonPublisher;
    }

    @PostMapping
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonPublisher.sendJsonMessage(user);
        return ResponseEntity.ok("Json message send to RabbitMQ....");
    }
}
