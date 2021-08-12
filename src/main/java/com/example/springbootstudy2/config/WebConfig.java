package com.example.springbootstudy2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

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
    // 전반 적인 cors 설정
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 전체 global 설정 
                .allowedOrigins("http://localhost:18080");
        /*
        registry.addMapping("/rest/hello") // 일부 
                .allowedOrigins("http://localhost:18080");

         */
    }
    // url 과 맵핑을 시켜 준다
    // 특정 요청이 들어올때 로직없이 view 보여주는 경우 사용
    /*
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
    }

     */
}
