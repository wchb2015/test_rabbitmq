package com.ele.rabbitmq.helloworld;

import com.alibaba.fastjson.JSON;
import com.ele.rabbitmq.dto.MessageDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-context.xml")
public class MessageServiceTest {

    //    private String routingKey = "rabbit_queue_one_0420";
    private String routingKey = "lpd.meepo.ws.knight.team.change";
    private String message = "这个消息哈哈......AAAAA";

    @Autowired
    private MessageProducerService producerService;

    @Test
    public void pushToMessageQueue() {
        producerService.pushToMessageQueue(routingKey, covertObject2json());
    }

    private String covertObject2json() {
        MessageDTO msg = new MessageDTO();
        msg.setKnight_id(888L);
        msg.setOperation_type(1);
        msg.setOrg_name("测试代理商");
        msg.setTeam_name("测试团队名字");
        return JSON.toJSONString(msg);
    }

}