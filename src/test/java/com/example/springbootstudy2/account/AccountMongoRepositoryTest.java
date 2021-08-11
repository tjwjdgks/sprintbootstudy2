package com.example.springbootstudy2.account;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// 몽고 db는 내장형 mongo db가 있음 test에 용이
// dependency
// de.flapdoodle.embed
// de.flapdoodle.embed.mongo
@ExtendWith(SpringExtension.class)
@DataMongoTest // slice test
class AccountMongoRepositoryTest {
    @Autowired
    AccountMongoRepository accountMongoRepository;
    @Test
    public void findByEmail(){
        AccountMongo mongo = new AccountMongo();
        mongo.setEmail("test");
        mongo.setUsername("seo");
        accountMongoRepository.save(mongo);
        Optional<AccountMongo> byId = accountMongoRepository.findById(mongo.getId());
        assertThat(byId).isNotEmpty();
        Optional<AccountMongo> byEmail = accountMongoRepository.findByEmail(mongo.getEmail());
        assertThat(byEmail).isNotEmpty();
        assertThat(byEmail.get().getEmail()).isEqualTo("test");
    }
}