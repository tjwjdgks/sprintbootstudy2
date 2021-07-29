package com.example.springbootstudy2.runner;

import com.example.springbootstudy2.testbeans.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProfileRunner implements ApplicationRunner {
    @Autowired
    private Hello hello;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("=======");
        System.out.println(hello.getOut());
        System.out.println("=======");

    }
}
