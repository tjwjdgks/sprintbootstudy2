package com.example.springbootstudy2.account;


import org.springframework.data.jpa.repository.JpaRepository;

// entity 다음 id type 으로 jpaRepository 상속
public interface AccountRepository extends JpaRepository<Account,Long> {

}
