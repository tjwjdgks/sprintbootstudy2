package com.example.springbootstudy2.runner;


import com.example.springbootstudy2.account.AccountNeo4j;
import com.example.springbootstudy2.account.AccountNeo4jRepository;
import com.example.springbootstudy2.account.Role;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.ReactiveTransactionManager;
import reactor.core.publisher.Mono;

@Component
public class Neo4jRunner implements ApplicationRunner {
    @Autowired
    AccountNeo4jRepository accountNeo4jRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        AccountNeo4j accountNeo4j = new AccountNeo4j();
        accountNeo4j.setEmail("test@test.com");
        accountNeo4j.setUsername("test");

        Role role = new Role();
        role.setName("admin");

        accountNeo4j.getRoles().add(role);

        AccountNeo4j save = accountNeo4jRepository.save(accountNeo4j);
        System.out.println("neo4j end");
    }
}
