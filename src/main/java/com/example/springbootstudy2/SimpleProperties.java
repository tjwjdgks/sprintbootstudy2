package com.example.springbootstudy2;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

// 프로퍼티 bean 으로 등록
// getter setter 필요하다 자동 바인딩
// meta 정보 생성 플러그인 도움을 받는다 autoconfigure-processor
// type converstion 된다
// 시간 정보도 가능
@Component
@ConfigurationProperties("simple")
@Validated
public class SimpleProperties {
    @NotNull
    private int age;
    private String name;
    private String full;

    @DurationUnit(ChronoUnit.SECONDS)
    private Duration sessiontime = Duration.ofSeconds(30);

    public Duration getSessiontime() {
        return sessiontime;
    }

    public void setSessiontime(Duration sessiontime) {
        this.sessiontime = sessiontime;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }
}
