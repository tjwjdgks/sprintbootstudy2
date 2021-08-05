package com.example.springbootstudy2.controller;

import com.example.springbootstudy2.objects.HelloHateoas;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class HateoasController {
    @GetMapping("/hello/hateoas")
    public EntityModel<HelloHateoas> hello(){
        HelloHateoas helloHateoas = new HelloHateoas();
        helloHateoas.setPrefix("hey");
        helloHateoas.setName("seo");

        // 해이토스 링크 정보 추가하는 법
        // 헤이토스의 리소스는 제공 리소스 + 링크 정보
        EntityModel<HelloHateoas> helloHateoasEntityModel = EntityModel.of(helloHateoas);
        // 링크 정보 만드는 방법 중 하나
        // hello의 메소드에 대한 링크를 따서 링크를 self라는 relation 으로 추가
        helloHateoasEntityModel.add(linkTo(methodOn(HateoasController.class).hello()).withSelfRel());
        return helloHateoasEntityModel;
    }

}
