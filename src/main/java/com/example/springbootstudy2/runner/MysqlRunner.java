package com.example.springbootstudy2.runner;
/*
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
public class MysqlRunner implements ApplicationRunner {
    Logger logger = LoggerFactory.getLogger(MysqlRunner.class);

    @Autowired
    DataSource source;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // try resource try로 잡을 경우 block 안에서 정리를 해준다
        // connection은 많은 정보를 담고 있음
        // connection을 미리 만들어 놓고 application이 가져다 사용한다
        // dbcp(database connection pool) 성능에 영향을 많이 끼친다. spring boot 기본 Hikari CP
        // connection time, connection 객체를 몇개 사용(cpu core 개수와 동일) 할 지 중요함

        try (Connection connection = source.getConnection()) {
            logger.debug(connection.getMetaData().getURL());
            logger.debug(connection.getMetaData().getUserName());
            System.out.println(source.getClass());
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
*/