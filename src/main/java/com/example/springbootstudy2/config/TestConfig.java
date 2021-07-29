package com.example.springbootstudy2.config;

import com.example.springbootstudy2.testbeans.Hello;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("test")
@Configuration
public class TestConfig {
    @Bean
    public Hello hello(){
        return new Hello("test hello");
    }
}
