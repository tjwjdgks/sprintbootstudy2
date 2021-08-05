package com.example.springbootstudy2.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ViewController.class)
class ViewControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void viewHello() throws Exception {
        // 요청 /view/hello
        // 응답 모델 name에 seo가 들어감
        // 응답 뷰 이름 hello
        mockMvc.perform(get("/view/hello"))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(view().name("helloview"))
                .andExpect(model().attribute("name",is("seo")))
                .andExpect(content().string(containsString("seo"))); // content 확인

    }
    /*

    jsp 본문 확인 어려움, 실제 렌더링 자체를 서블릿 엔진이 담당했기 때문에
    서블릿엔진의 개입을 통해 결과를 확인 할 수 있음
    but 타임리프는 독자적으로 view를 구성 서블릿 엔진의 개입이 없음 본문을 확인하기 쉬움

    mockMvc도 실제 서블릿 컨테이너를 띄우는 것이 아니기 때문에 jsp는 test에 어려움이 있음
     */
}