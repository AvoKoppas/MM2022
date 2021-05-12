package com.example.MM2022.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void registerUser(String userName, String password) {

    }
}
