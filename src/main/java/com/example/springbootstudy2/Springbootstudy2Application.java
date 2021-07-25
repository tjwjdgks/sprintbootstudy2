package com.example.springbootstudy2;

import me.seo.Holomen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/*
mvn package jar 파일 생성
 */
/*
spring boot 기본 구조 프로젝트
src-main-java 에 java source code
src-main-resources 에  java code를 제외한 모든 것 class path root
test에 resources 넣을 수 있음
main은 default package에 사용

spring 의존성 관리 기능
spring-boot-starter-parent 에 parent인 spring-boot-dependencies 가 가장 위에 있음
spring boot dependencies 에서 dependencies management에서 버전 관리
장점 의존성의 수가 줄어든다 호환성이 좋음
starter 위주로
spring-boot-starter-parent에서 properties 관리 spring boot 최적화 설정 해준다

의존성 관리 활용
mvn repository에서 depenencies 추가
spring boot가 관리하지 않는 모델 버전은 명시 해야함
spring boot가 관리하는 기존 버전 properties에 추가해서 변경

 */
@SpringBootApplication
/*
@SpringBootApplication가 하는 기능 3가지

@SpringBootConfiguration // configuration과 비슷한 애노테이션
//빈 등록
@ComponentScan // 빈을 ComponentScan 단계로 등록 Component 애노테이션 bean 등록
@EnableAutoConfiguration // 읽어온 빈들을 등록 meta file, java resources 안에 meta 디렉토리 안에 spring.factories에 등록
AutoConfiguration도 자바 설정 파일 조건에 따라 bean 등록 달라진다
// 빈 등록 componentscan으로 등록 먼저 하고 autoconfiguration 사용 
 */
public class Springbootstudy2Application {

    public static void main(String[] args) {
        /*
        // @Configuration @ComponentScan 만 사용
        // spring application 커스텀 // webapplication 사용 x
        SpringApplication application = new SpringApplication(Springbootstudy2Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
         */
        SpringApplication.run(Springbootstudy2Application.class, args);
    }

}
