package com.demo.rabbitmq_demo.publisher;

import com.demo.rabbitmq_demo.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonPublisher {

    @Value("${rabbitmq.json.routing.name}")
    private String jsonBinding;

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);

    private final RabbitTemplate template;

    public RabbitMQJsonPublisher(RabbitTemplate template) {
        this.template = template;
    }

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("Json message sent -> %s", user.toString()));
        template.convertAndSend(exchange, jsonBinding, user);
    }
}
