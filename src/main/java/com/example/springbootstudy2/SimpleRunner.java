package com.example.springbootstudy2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SimpleRunner implements ApplicationRunner {

    private Logger logger = LoggerFactory.getLogger(SimpleRunner.class);

    @Autowired
    SimpleProperties properties;
    @Value("${seo.name}")
    private String name;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.debug("============================");
        logger.debug(name);
        logger.debug("============================");



        System.out.println("simpleRunner " + name);
        System.out.println(properties.getName());
        System.out.println(properties.getAge());
        System.out.println(properties.getSessiontime());

    }
}
