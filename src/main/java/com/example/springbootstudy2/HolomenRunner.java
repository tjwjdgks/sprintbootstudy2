package com.example.springbootstudy2;

import me.seo.Holomen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class HolomenRunner implements ApplicationRunner {

    // bean 등록하기 새로운 프로젝트 Holomen은 C:\Users\SEO\Documents\GitHub\holotest 사용
    @Autowired
    Holomen holomen;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(holomen);
    }
}
