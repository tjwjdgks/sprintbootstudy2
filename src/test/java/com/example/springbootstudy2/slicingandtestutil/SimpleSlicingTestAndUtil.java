package com.example.springbootstudy2.slicingandtestutil;

import com.example.springbootstudy2.service.SimpleService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import javax.validation.constraints.AssertTrue;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
/*
슬라이스 테스트
레이어 별로 잘라서 테스트하고 싶을 때
@JsonTest
@WebMvcTest
@WebFluxTest
@DataJpaTest
 */
@ExtendWith(SpringExtension.class)
@WebMvcTest // web과 관련된 것만 등록 된다 // service, repo 는 등록 x
// outputcapture log를 비롯해서 콘솔에 찍히는 모든 것을 캡처한다
@ExtendWith(OutputCaptureExtension.class)
public class SimpleSlicingTestAndUtil {



    // 의존성이 끊기는 것은 mockbean을 통해서 해결
    @MockBean
    SimpleService simpleService;

    @Autowired
    MockMvc mockMvc;
    @Test
    public void hi(CapturedOutput capturedOutput) throws Exception {
        when(simpleService.getName()).thenReturn("seo test");
        mockMvc.perform(get("/hi")).andExpect(content().string("hi seo test"));

        String s = capturedOutput.toString();
        assertTrue(s.contains("vip"));
        assertTrue(s.contains("skip"));
    }
}
