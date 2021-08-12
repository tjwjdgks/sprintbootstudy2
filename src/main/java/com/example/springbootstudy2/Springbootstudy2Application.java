package com.example.springbootstudy2;

import com.example.springbootstudy2.Listener.SimpleListener;
import me.seo.Holomen;
//import org.apache.catalina.Context;
//import org.apache.catalina.LifecycleException;
//import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.connector.Connector;
import org.neo4j.driver.Driver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.core.ReactiveDatabaseSelectionProvider;
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager;
import org.springframework.data.neo4j.repository.config.ReactiveNeo4jRepositoryConfigurationExtension;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

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

spring boot 자체는 웹서버 아니다

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
/*
기본 내장 웹 서버 톰켓
 */
public class Springbootstudy2Application {

    public static void main(String[] args) throws LifecycleException, IOException {
        /*
        // @Configuration @ComponentScan 만 사용
        // spring application 커스텀 // webapplication 사용 x
        SpringApplication application = new SpringApplication(Springbootstudy2Application.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);
         */
        // instance 만들어서 run 하는 방법이 효과적
        // -Ddebug 모드를 사용하면 autoconfiguration 자동설정 확인 가능
        SpringApplication app = new SpringApplication(Springbootstudy2Application.class);
        app.addListeners(new SimpleListener());
        // WebApplicationType.SERVLET spring mvc가 들어 있을 경우 기본으로
        // WebApplicationType.REACTIVE srping webflux (서블릿 없을 경우) 서블릿이 있으면 SERVLET
        // 둘다 없을 경우 None으로 동작
        // jvm argument -D application argument -- 으로 시작한다
        //app.setWebApplicationType(WebApplicationType.NONE);
        app.setWebApplicationType(WebApplicationType.SERVLET);
        app.run(args);

        /*
        ServeletWebServerFactoryAutoConfiguration이 서블릿 웹 서버 자동 설정
        web mvc 디스패처 서블릿 필요 <= http 서블릿 상속받아 만든 것
        서블릿 웹 서버 설정과 디스패처 서블릿 설정이 나뉜 이유
        웹 서버 설정과 서블릿은 독립적이다 웹 서버 설정이 서블릿에 영항 x

        */
        /*
        // 자바로 tomcat 만들기
        // 톰켓 객체 생성
        Tomcat tomcat = new Tomcat();
        // 톰켓 포트 설정
        tomcat.setPort(8080);
        // connector 설정
        tomcat.getConnector();

        // 톰켓 docBase 설정
        // tomcat.8080 directory
        String docBase = Files.createTempDirectory("tomcat-basedir").toString();
        // 톰켓에 context 추가
        Context context = tomcat.addContext("/", docBase);
        // 서블릿 만들기
        HttpServlet servlet = new HttpServlet() {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                PrintWriter writer = resp.getWriter();
                writer.println("<html><head><title>");
                writer.println("Hey tomcat");
                writer.println("</title></head>");
                writer.println("<body><h1> Hello tomcat </body></h1>");
                writer.println("</html>");
            }
        };
        String servletName = "helloServlet";
        // 경로 서블릿 이름, 서블릿 객체
        // 톰켓에 서블릿 추가
        tomcat.addServlet("/",servletName,servlet);
        // 컨텍스트에 서블릿 매핑
        context.addServletMappingDecoded("/hello",servletName);
        tomcat.start();
        tomcat.getServer().await();

         */
    }
    /*
    // Holomen autoconfiguration에서 해당 bean이 있으므로 bean 등록 x,  holomen 에서 bean 등록했을 때  @ConditionalOnMissingBean annotation 사용
    @Bean
    public Holomen holomen(){
        Holomen holomen = new Holomen();
        holomen.setName("test");
        holomen.setHowLong(10);
        return holomen;
    }

     */

    // Http 커넥터 추가
    @Bean
    public ServletWebServerFactory serverFactory(){
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createStandardConnector());
        return tomcat;
    }

    private Connector createStandardConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(8080);
        return connector;
    }

    // 스프링 rest 클라이언트 전역적 커스터마이징 방법
    /*
    @Bean
    public WebClientCustomizer webClientCustomizer(){
        return new WebClientCustomizer() {
            @Override
            public void customize(WebClient.Builder webClientBuilder) {
                webClientBuilder.baseUrl("http://localhost:8080"); // webclient builder는 baseurl 가진 상태에서 주입 된다
            }
        };
    }

     */
    /*
    // apache http client 사용하는 방법
    // java http connection 사용하지 않음
    @Bean
    public RestTemplateCustomizer restTemplateCustomizer(){
        return new RestTemplateCustomizer() {
            @Override
            public void customize(RestTemplate restTemplate) {
                restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
            }
        };
    }

     */
}
