package com.example.springbootstudy2.config;

import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
//당신의 빈 등록은 간편하게 @Component 어노테이션으로, 유연한 빈 등록이 필요하다면 @Configuration 어노테이션이 들어간 클래스 내 @Bean 어노테이션 메소드 선언으로
public class PropertiesConfig {
    // 외부 라이브러리에서도 properties 가져올 수 있음 but 이미 bean으로 바인딩 되므로 사실상 유의미 x
    /*
    @Primary
    @ConfigurationProperties("server")
    @Bean
    public ServerProperties serverProperties(){
        return new ServerProperties();
    }

     */
}
