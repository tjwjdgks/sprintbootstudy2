package com.example.springbootstudy2.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void userHello() throws Exception {
        mockMvc.perform(get("/userHello"))
                .andExpect(status().isOk())
                .andExpect(content().string("userHello"));
    }
    @Test
    public void createUser_JSON() throws Exception {
        // mediatype spring framework 제공
        // json "key" : "value" 형태
        String userJson = "{\"username\":\"seo\", \"password\":\"123\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(userJson))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.username", is(equalTo("seo"))))
                    .andExpect(jsonPath("$.password", is(equalTo("123"))));
    }

    // 스프링 부트 뷰 리졸버 설정 제공 content negotiation view resolver 설명
    //content negotiation view resolver란 들어오는 요청에 accept header에 따라 응답이 달라진다. accept 헤더는 특정 type의 본문을 요구하는 것
    // content negotiation view resolver 적용 client json이 아닌 xml 요청
    @Test
    public void createUser_XML() throws Exception {
        // mediatype spring framework 제공
        // json "key" : "value" 형태
        // http message conveter는 HttpMessageConvertersAutoConfiguration 설정
        // test 실패시 andDo(print()) 실행
        String userJson = "{\"username\":\"seo\", \"password\":\"123\"}";
        mockMvc.perform(post("/users/create")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_XML)
                .content(userJson))
                .andExpect(status().isOk())
                .andExpect(xpath("/User/username").string("seo"))
                .andExpect(xpath("/User/password").string("123"));
    }
}
