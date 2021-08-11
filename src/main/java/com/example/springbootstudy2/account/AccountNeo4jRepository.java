package com.example.springbootstudy2.account;


import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.repository.CrudRepository;

public interface AccountNeo4jRepository extends Neo4jRepository<AccountNeo4j,Long> {
}
