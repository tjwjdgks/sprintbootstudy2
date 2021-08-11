package com.example.springbootstudy2.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

// 슬라이싱 test 인메모리 데이터 베이스 필요하다, 슬라이싱 test 권장
@ExtendWith(SpringExtension.class)
// 아래의 properties override 또는 schema.sql 파일 만들어서 ddl 제한 피하기
//@DataJpaTest(properties = {"spring.jpa.hibernate.ddl-auto= create","spring.jpa.generate-ddl=true"})
@DataJpaTest // repository만 관련된 bean 만 test
class AccountRepositoryTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    Environment environment;
    // 비어 있는 test로 bean들이 등록이 잘되었는지 test 가능
    @Test
    public void di() throws SQLException {
        System.out.println(environment.getProperty("testtest.ss"));
        System.out.println(environment.getProperty("testtest.name"));
        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getURL());
            System.out.println(metaData.getDriverName());
            System.out.println(metaData.getUserName());
        }
        Account account = new Account();
        account.setUsername("seo");
        account.setPassword("pass");

        Account newAccount = accountRepository.save(account); // 저장하면 저장된 객체 나옴

        assertNotNull(newAccount);

        Account byUsername = accountRepository.findByUsername(newAccount.getUsername());
        assertNotNull(byUsername);
        Account nonUsername = accountRepository.findByUsername("test");
        assertNull(nonUsername);
    }
}