package com.example.springbootstudy2.runner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@Component
public class H2Runner implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(H2Runner.class);

    @Autowired
    DataSource source;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // try resource try로 잡을 경우 block 안에서 정리를 해준다
        try (Connection connection = source.getConnection()) {
            // 스프링 부트 기본 인메모리 DB 설정이 매번 새로운 이름으로 만들어 지도록 2.3부터 변경되
            logger.debug(connection.getMetaData().getURL());
            logger.debug(connection.getMetaData().getUserName());
            // trancation 적용
            // 원래 try catch 로 예외처리
            // 예외시 roll back
            Statement statement = connection.createStatement();
            String sql = "CREATE TABLE USER(ID INTEGER NOT NULL, name VARCHAR(255), PRIMARY KEY (id))";
            statement.executeUpdate(sql);
        }
        jdbcTemplate.execute("INSERT INTO USER VALUES (1,'SEO')");

    }
}
