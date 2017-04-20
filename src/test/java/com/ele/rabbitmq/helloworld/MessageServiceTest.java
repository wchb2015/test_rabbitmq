package com.ele.rabbitmq.helloworld;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class MessageServiceTest {

    private String routingKey = "rabbit_queue_one_0420";
    private String message = "这个消息哈哈......AAAAA";

    @Autowired
    private MessageProducerService producerService;

    @Test
    public void pushToMessageQueue() {
        producerService.pushToMessageQueue(routingKey, message);
    }

}