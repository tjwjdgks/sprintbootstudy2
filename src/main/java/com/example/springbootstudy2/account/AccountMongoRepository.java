package com.example.springbootstudy2.account;


import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountMongoRepository extends MongoRepository<AccountMongo,String> {
    Optional<AccountMongo> findByEmail(String email);
}
