package com.ele.rabbitmq.helloworld;

import com.ele.rabbitmq.comsumer.MessageConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-mq.xml")
public class MessageServiceTest {

    private String routingKey;
    private String message;

    @Autowired
    private MessageConsumerService consumerService;

    @Autowired
    private MessageProducerService producerService;

    @Test
    public void pushToMessageQueue() {
        routingKey = "test_queue_1";
        message = "Test ";
        producerService.pushToMessageQueue(routingKey, message);
    }

    @Test
    public void popMessage() throws Exception {
        consumerService.popMessage("test_queue_1");
    }

}