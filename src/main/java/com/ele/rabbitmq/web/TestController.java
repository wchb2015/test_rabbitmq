package com.ele.rabbitmq.web;

import com.alibaba.fastjson.JSON;
import com.ele.rabbitmq.producer.MessageProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class TestController {

    @Autowired
    private MessageProducerService messageProducerService;

    @ResponseBody
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        messageProducerService.pushToMessageQueue("lpd.meepo.ws.knight.team.change", JSON.toJSONString(""));
        return "success";
    }

}
