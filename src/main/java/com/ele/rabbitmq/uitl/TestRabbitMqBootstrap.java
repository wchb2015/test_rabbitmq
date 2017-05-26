package com.ele.rabbitmq.uitl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;

public class TestRabbitMqBootstrap extends Bootstrap {

    private static Logger LOG = LoggerFactory.getLogger(TestRabbitMqBootstrap.class);

    public static void main(String[] args) {
        initApplicationContext(args);
    }

    private static void initApplicationContext(String... configLocations) throws BeansException {
        Bootstrap.main(configLocations);
        LOG.info("***************Start Success!!!!**********************");
    }

}
