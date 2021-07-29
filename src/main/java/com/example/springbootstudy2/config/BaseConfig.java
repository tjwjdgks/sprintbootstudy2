package com.example.springbootstudy2.config;

import com.example.springbootstudy2.testbeans.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("prod")
@Configuration
public class BaseConfig {
    @Bean
    public Hello hello(){
        return new Hello("hello");
    }
}

