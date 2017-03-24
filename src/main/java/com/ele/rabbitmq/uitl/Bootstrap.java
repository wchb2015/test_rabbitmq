package com.ele.rabbitmq.uitl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {

    private static Logger LOG = LoggerFactory.getLogger(Bootstrap.class);

    public static void main(String[] args) {
        try {
            if (args == null || args.length == 0) {
                LOG.info("spring server bootstrap use config file : application-context.xml under the classpath.");
                new ClassPathXmlApplicationContext("classpath:spring/application-context.xml");
            } else {
                new ClassPathXmlApplicationContext(args);
            }
        } catch (Throwable t) {
            LOG.error("Throwable Occurs in Bootstrap!", t);
            System.exit(-1);
        }
    }
}
