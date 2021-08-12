package com.example.springbootstudy2.runner;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class RestRunner2 implements ApplicationRunner {
    @Autowired
    WebClient.Builder builder;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        WebClient webClient = builder.build();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 실행 후 아무일이 일어나지 않는다 stream api이다
        Mono<String> stringMono = webClient.get().uri("http://localhost:8080/restapi/hello")
                .retrieve()
                .bodyToMono(String.class);
        stringMono.subscribe(s -> {  // 실제 동작
            System.out.println(s);
            if(stopWatch.isRunning())
                stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
            stopWatch.start();
        });
        Mono<String> stringMono2 = webClient.get().uri("http://localhost:8080/restapi/world")
                .retrieve()
                .bodyToMono(String.class);
        stringMono2.subscribe(s -> {  // 실제 동작
            System.out.println(s);
            if(stopWatch.isRunning())
                stopWatch.stop();
            System.out.println(stopWatch.prettyPrint());
            stopWatch.start();
        });
        stopWatch.stop();
    }
}


 */