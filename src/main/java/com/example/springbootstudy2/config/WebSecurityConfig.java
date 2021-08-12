package com.example.springbootstudy2.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// websecurity 자동 설정 쓰지 않으면서 모방하는 방법
@Configuration
/*
spring boot 가 제공해 주는 spring boot security auto configuration 적용 안됨
    - because WebSecurityConfigurerAdapter bean을 등록했기 때문에, 사용자가 커스텀 할 수 있음
*/
// 웹 시큐리티 설정
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/","/home","/restapi/*").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .and()
            .httpBasic();


        // 모든 request 퍼미션 추가
        //http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
    }
    // password encoder 회피 방법 (회피할 수 있으나 보안 이슈 때문에 추천하지 않음)
    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
