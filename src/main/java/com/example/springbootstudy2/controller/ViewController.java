package com.example.springbootstudy2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/view/hello")
    // helloview라는 view에 model 정보는 model 객체에 담을 수 있다
    public static String hello(Model model){
        model.addAttribute("name","seo");
        return "helloview";
    }
}
