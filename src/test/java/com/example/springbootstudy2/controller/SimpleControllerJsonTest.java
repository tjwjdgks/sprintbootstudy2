package com.example.springbootstudy2.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.test.context.junit.jupiter.SpringExtension;


// json test 실험해볼 도메인
@ExtendWith(SpringExtension.class)
@SpringBootTest
@JsonTest
public class SimpleControllerJsonTest {
    //@Autowired
    // JacksonTester<> <- 안에 도메인
    // https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#features.testing.spring-boot-applications.json-tests
}
