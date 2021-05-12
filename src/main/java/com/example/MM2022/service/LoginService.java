package com.example.MM2022.service;

import com.example.MM2022.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    LoginRepository loginRepository;
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    //registreerimise meetod
    public void registerUser (String userName, String password) {
        loginRepository.registerUser (userName, password);
    }


    //login meetod
    public void login (String userName, String password) {

    }
}
