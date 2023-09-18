package com.demo.rabbitmq_demo.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {


    @Value("${rabbitmq.routing.name}")
    private String routingKey;
    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQProducer.class);
    private final RabbitTemplate template;

    public RabbitMQProducer(RabbitTemplate template) {
        this.template = template;
    }

    public void sendMessage(String message){
        LOGGER.info(String.format("Message sent -> %s", message));
        template.convertAndSend(exchange, routingKey, message);
    }
}
