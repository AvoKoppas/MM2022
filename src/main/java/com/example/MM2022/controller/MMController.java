package com.example.MM2022.controller;

import com.example.MM2022.service.MMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MMController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    MMService mmService;

    @GetMapping("calculateScore/")
//    public void calculateScore(int resultHome, int resultAway,
//                               int predictionHome, int predictionAway) {
//        mmService.calculate(resultHome, resultAway, predictionHome,predictionAway);
//    }

    //http://localhost:8080/insert/Mari/1/2/3
    @PostMapping("insert/{userName}/{gameId}/{predictionA}/{predictionB}")
    public void insert(@PathVariable("userName") String userName,
                       @PathVariable("gameId") int gameId,
                       @PathVariable("predictionA") int predictionA,
                       @PathVariable("predictionB") int predictionB){
        mmService.insertPrediction(userName, gameId, predictionA, predictionB);
    }

    //http://localhost:8080/insertScore/1/2/3
    @PostMapping("insertScore/{gameNr}/{resultA}/{resultB}")
    public void insertScore (@PathVariable("gameNr") int gameNr,
                             @PathVariable("resultA") int resultA,
                             @PathVariable("resultB") int resultB) {
        mmService.insertRealScore(gameNr, resultA, resultB);
    }

//    @PostMapping("")
//    public int(){
//
//    }

}