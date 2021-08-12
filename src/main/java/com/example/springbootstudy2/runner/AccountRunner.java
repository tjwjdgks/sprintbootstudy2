package com.example.springbootstudy2.runner;

import com.example.springbootstudy2.account.Account;
import com.example.springbootstudy2.account.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

// 사용할 user 생성
@Component
public class AccountRunner implements ApplicationRunner {
    @Autowired
    AccountService accountService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account seo = accountService.createAccount("seo", "1111");
        System.out.println(seo.getUsername()+ " " + seo.getPassword());
    }
}
