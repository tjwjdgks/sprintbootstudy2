package com.example.springbootstudy2.user;

import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @GetMapping("/userHello")
    public String hello(){
        return "userHello";
    }
    //TODO HTTP 요청 본문을 객체로 변경하거나, 객체를 HTTP 응답 본문으로 변경할 때 HttpMessageConveters 사용 된다
    // https://docs.spring.io/spring/docs/5.0.7.RELEASE/spring-framework-reference/web.html#mvc-config-message-converters

    // 어떤 요청을 받았는지 어떤 요청을 보내야하는지에 따라 사용하는 http message converter가 다르다
    // ex contentype이 json 이고 json으로 보내야한다면 json converter가 사용되어 User로 바꿔준다.
    // 객체를 요청 body로 변경할 때 객체가 여러가지 value를 가진다면 json converter가 사용된다
    // RestController일 경우 @ResponseBody 생략 가능능    @PostMapping("/user")
    // 그냥 controller일 경우 ViewNameResolver view를 찾으려고 함
    /*
    public @ResponseBody User create(@RequestBody User user){
        return null;
    }
    */

    @PostMapping("/users/create")
    public User create(@RequestBody User user){
        return user;
    }



}
