package com.example.springbootstudy2.account;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

// entity 다음 id type 으로 jpaRepository 상속
public interface AccountRepository extends JpaRepository<Account,Long> {
    //네이티브 쿼리 가능 '{0}'은  플레이스 홀더
    //@Query(nativeQuery = true,value= "select * from account where username ='{0}'")
    // 기본값은 jpql을 사용해야함
    // Optional<Account> findByUsername(String username); assertIsEmpty or assertEmpty 사용
    Optional<Account> findByUsername(String username);
}
