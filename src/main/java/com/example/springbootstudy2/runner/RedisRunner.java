package com.example.springbootstudy2.runner;

import com.example.springbootstudy2.account.AccountRedis;
import com.example.springbootstudy2.account.AccountRedisRepository;
import com.example.springbootstudy2.account.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    AccountRedisRepository accountRedisRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        // value operation 제공
        ValueOperations<String, String> values = stringRedisTemplate.opsForValue();
        // key value
        values.set("seo","test");
        values.set("springboot","current");
        values.set("hello","word");
        AccountRedis accountRedis = new AccountRedis();
        accountRedis.setEmail("tjwjdgks");
        accountRedis.setUsername("seo");
        accountRedisRepository.save(accountRedis);
        // optional로 나온다
        Optional<AccountRedis> byId = accountRedisRepository.findById(accountRedis.getId());
        System.out.println(byId.get().getEmail());
        System.out.println(byId.get().getUsername());
    }
}
