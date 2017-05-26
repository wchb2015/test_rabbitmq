package com.ele.rabbitmq.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class MessageProducerServiceTest {

    private String routingKey = "lpd.meepo.ws.knight.team.change";

    @Autowired
    private MessageProducerService producerService;

    @Test
    public void pushToMessageQueue() throws Exception {
        producerService.pushToMessageQueue(routingKey, "haha");
    }

}