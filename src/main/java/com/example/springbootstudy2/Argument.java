package com.example.springbootstudy2;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

// bean이고 생성자가 하나이면서 bean을 받는 것은 해당 파라이터를 bean으로 자동 주입해준다
@Component
public class Argument {

    public Argument(ApplicationArguments applicationArguments){
        System.out.println("foo: " + applicationArguments.containsOption("foo"));
        System.out.println("bar: " + applicationArguments.containsOption("bar"));
    }
}
