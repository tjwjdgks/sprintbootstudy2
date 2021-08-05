package com.example.springbootstudy2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// spring boot의 기능들을 확장하고 싶을 때 추가적으로 설정 할때 WebMvcConfigurer +  @Configuration
@Configuration
// @EnableWebMvc // 모든 설정을 user가 해야한다
public class WebConfig implements WebMvcConfigurer {
    // 리소스 찾을 위치 커스터 마이징
    // 리소스 핸들러 추가
    // cache control 직접 해야 한다
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("dev/**")
                .addResourceLocations("classpath:/dev/") // 반드시 /로 끝내야한다
                .setCachePeriod(20); // 초단위
    }
}
