package com.example.springbootstudy2.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.sql.DataSource;

import static org.junit.jupiter.api.Assertions.*;

// 슬라이싱 test
@ExtendWith(SpringExtension.class)
@DataJpaTest // repository만 관련된 bean 만 test
class AccountRepositoryTest {
    @Autowired
    DataSource dataSource;
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountRepository accountRepository;

    // 비어 있는 test로 bean들이 등록이 잘되었는지 test 가능
    @Test
    public void di(){

    }
}