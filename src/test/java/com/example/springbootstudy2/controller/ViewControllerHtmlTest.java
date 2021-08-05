package com.example.springbootstudy2.controller;

import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlHeading1;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ViewController.class)
public class ViewControllerHtmlTest {
    // webclient 사용시 MockMvc 사용
    @Autowired
    WebClient webClient;

    @Test
    public void hello() throws IOException {
        // 자동완성 page이지만 HtmlPage로 바꾸면 다양한 메소드 사용 가능
        HtmlPage page = webClient.getPage("/view/hello");
        HtmlHeading1 h1 = page.getFirstByXPath("//h1");// h1 가장 앞에 있는 것 하나 가져오는 것
        assertTrue("seo".equalsIgnoreCase(h1.getTextContent()));



    }
}
