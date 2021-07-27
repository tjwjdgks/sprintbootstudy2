package com.example.springbootstudy2;

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
    // 외부 라이브러리에서도 properties 가져올 수 있음 but 이미 bean으로 바인딩 되므로 사실상 유의미 x
    @ConfigurationProperties("server")
    @Bean
    public ServerProperties serverProperties(){
        return new ServerProperties();
    }
    @Autowired
    SimpleProperties properties;
    @Value("${seo.name}")
    private String name;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("simpleRunner " + name);
        System.out.println(properties.getName());
        System.out.println(properties.getAge());
        System.out.println(properties.getSessiontime());

    }
}
