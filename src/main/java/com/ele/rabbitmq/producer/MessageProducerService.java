package com.ele.rabbitmq.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageProducerService {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void pushToMessageQueue(String routingKey, String message) {
        amqpTemplate.convertAndSend(routingKey, message);
    }
}
