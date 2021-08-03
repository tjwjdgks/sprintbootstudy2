package com.example.springbootstudy2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// spring boot의 기능들을 확장하고 싶을 때 추가적으로 설정 할때 WebMvcConfigurer +  @Configuration
@Configuration
// @EnableWebMvc // 모든 설정을 user가 해야한다
public class WebConfig implements WebMvcConfigurer {

}
