package com.example.springbootstudy2.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

@Service
// Service type의 빈이 등록이 되어 있어야 Spring boot가 자동 생성 user 사용 안되고 사용자가 만든 것을 통해서 로그인 처리
//UserDetailsService 구현
// 보통 User정보를 관리하고 있는 Service 계층에 UserDetailsService 구현한다
// password encoding 반드시 해야함
public class AccountService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    // passwordEncoder 설정
    private PasswordEncoder passwordEncoder;

    public Account createAccount(String username,String password){
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(passwordEncoder.encode(password));
        account.setActive(true);
        return accountRepository.save(account);
    }
    // username을 통해서 -> User정보를 얻어온다, UserDetails안에 password 있음
    // 핵심적인 인터페이스
    // UserDetails는 User라는 이름으로 제공한다

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> byUsername = accountRepository.findByUsername(username);
        Account account = byUsername.orElseThrow(() -> new UsernameNotFoundException(username));
        return new User(account.getUsername(),account.getPassword(),authorities());
    }
    // USER 권한 메소드
    private Collection<? extends GrantedAuthority> authorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
    }
}
