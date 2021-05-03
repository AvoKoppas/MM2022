package com.example.MM2022.controller;

import com.example.MM2022.service.MMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MMController {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    MMService mmService;

    @GetMapping
    public int calculate(int resultA, int resultB, int quessA, int quessB) {
        return -1;
    }

//    public String insert(String userName, int gameId, int predictionA, int predictionB){
//        mmService.
//    }
}