package com.example.springbootstudy2.account;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

// 각각의 document collection에 들어간다 collection -> table과 유사한 개념
@Document(collection = "accounts" )
public class AccountMongo {
    @Id
    private String id;

    private String username;
    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
