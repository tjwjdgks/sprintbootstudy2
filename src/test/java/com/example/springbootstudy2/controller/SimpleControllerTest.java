package com.example.springbootstudy2.controller;

import com.example.springbootstudy2.service.SimpleService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
// 서블릿 컨테이너를 띄우지 않고 목업을 해서 생성된다 따라서 요청을 하기 위해서는 MockMvc필요
// mock으로 사용하는 방법(1)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK) //(1)
// TEST용 web 클라이언트를 사용해야한다 실제 서블릿 구동
// Random port 사용하는 방법(2)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) //(2) RANDOM_PORT를 더 선호 but 특정 포트로 연결되었을 때 특정 포트 사용
// Mockmvc configuration
//@AutoConfigureMockMvc // (1)
@AutoConfigureWebTestClient // webTestClient bean 생성
class SimpleControllerTest {
    @Autowired
    // MockMvc mockMvc; //(1)
    //TestRestTemplate testRestTemplate; // (2)
    WebTestClient webTestClient; // (3) rest client이다, 기존 rest client은 동기적이지만 WebTestClient는 비동기적 (3)번 추천
    // test 에서 application context에서 만든 bean을 mockbean으로 교체, 모킹 가능
    @MockBean
    SimpleService mocService;

    @Test
    public void hi() throws Exception {
        /*
        // (1)
        mockMvc.perform(get("/hi"))
                .andExpect(status().isOk())
                .andExpect(content().string("hi seo"))
                .andDo(print());

         */

        when(mocService.getName()).thenReturn("seo test");
        // (2)
        /*
        //(2)
        String result = testRestTemplate.getForObject("http://localhost:8080/hi", String.class);
        assertEquals("hi seo test",result);

         */

        //(3)
        webTestClient.get().uri("http://localhost:8080/hi").exchange().expectStatus().isOk()
                .expectBody(String.class).isEqualTo("hi seo test");
    }
}