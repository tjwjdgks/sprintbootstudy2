package com.example.springbootstudy2;

import me.seo.Holomen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
//어플리케이션 실행 한 뒤에 다른 것 수행 하고 싶을 때
@Order(1) // 숫자를 두어서 Runner 순차적 실행 순자 낮은것이 높은 우선순위
public class HolomenRunner implements ApplicationRunner {

    // bean 등록하기 새로운 프로젝트 Holomen은 C:\Users\SEO\Documents\GitHub\holotest 사용
    @Autowired
    Holomen holomen;
    @Autowired
    ServerProperties serverProperties;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(holomen);
        System.out.println("runner " + args.containsOption("foo"));
        System.out.println("runner " + args.containsOption("bar"));
        System.out.println("test bean " + serverProperties.getPort());
    }
}
