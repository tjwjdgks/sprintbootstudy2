package com.example.springbootstudy2.runner;

import com.example.springbootstudy2.account.AccountMongo;
import com.example.springbootstudy2.account.AccountMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public class MongoRunner implements ApplicationRunner {
    // 기본 지원
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    AccountMongoRepository accountMongoRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        AccountMongo accountMongo = new AccountMongo();
        accountMongo.setEmail("aabb");
        accountMongo.setUsername("test");
        mongoTemplate.insert(accountMongo);
        accountMongo.setUsername("TEST2");
        accountMongoRepository.save(accountMongo);
        System.out.println("finished");
    }
}
