package com.example.springbootstudy2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

// test용 properties 만들 수 있음
// test code 실행 할 때 build 된다 이때 source 밑에 빌드해서 classpath에 들어간다 이후 test code 빌드하고 classpath에 들어간다 그리고 test에 있는 application properties 적용
//@TestPropertySource(properties = "seo.name = test") // annotation 방법
@TestPropertySource(locations = "classpath:test.properties") // location 방법
@SpringBootTest // test application.properties  보다 우선 순위 높음 (properties = "seo.name=fakedefault")
class Springbootstudy2ApplicationTests {

    // 모든 프로퍼티 들은 기본 적으로 enviroment를 통해서 확인할 수 있다.
    @Autowired
    Environment environment;

    @Test
    void contextLoads() {
        assertEquals("testfile",environment.getProperty("seo.name"));


    }

}
