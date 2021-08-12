package com.example.springbootstudy2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestClientController {
    @GetMapping("/restapi/hello")
    public String hello() throws InterruptedException {
        Thread.sleep(5000l);
        return "hello";
    }
    @GetMapping("/restapi/world")
    public String world() throws InterruptedException {
        Thread.sleep(3000l);
        return "world";
    }


}
