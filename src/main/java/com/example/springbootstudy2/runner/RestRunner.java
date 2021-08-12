package com.example.springbootstudy2.runner;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.client.RestTemplate;

import java.awt.desktop.SystemSleepEvent;

// spring-starter-web 모듈이 들어가 있기 때문에 rest template 사용가능
@Component
public class RestRunner implements ApplicationRunner {
    @Autowired
    RestTemplateBuilder restTemplateBuilder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        RestTemplate restTemplate = restTemplateBuilder.build();

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // TODO /hello
        // uri , 원하는 type
        // blocking io 기반 순차적 실행
        String resthelloresult = restTemplate.getForObject("http://localhost:8080/restapi/hello", String.class);
        System.out.println(resthelloresult);
        // TODO /world
        String restworldresult = restTemplate.getForObject("http://localhost:8080/restapi/world", String.class);
        System.out.println(restworldresult);

        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());
    }
}


 */