package com.example.springbootstudy2.account;

import org.springframework.data.repository.CrudRepository;

// CrudRepository spring data 최상위 interface
// bean으로 등록된다
public interface AccountRedisRepository extends CrudRepository<AccountRedis, String> {
}
