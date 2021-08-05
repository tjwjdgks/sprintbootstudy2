package com.example.springbootstudy2.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @CrossOrigin(origins = "http://localhost:18080") 컨트롤러 가능
public class CrossController {
    @CrossOrigin(origins = "http://localhost:18080") // cross origin 사용 방법 어노테이션 //
    @GetMapping("/rest/hello")
    public String Hello(){
        return "Hello";
    }
}
