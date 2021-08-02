package com.example.springbootstudy2.controller;

import com.example.springbootstudy2.service.SimpleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SimpleController {
    Logger logger = LoggerFactory.getLogger(SimpleController.class);
    @Autowired
    SimpleService simpleService;

    @GetMapping("/hi")
    public String hi(){
        logger.info("vip");
        System.out.println("skip");
        return "hi " + simpleService.getName();
    }
}
