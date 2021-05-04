package com.example.MM2022.service;

import com.example.MM2022.repository.MMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class MMService {
    @Autowired
    private MMRepository mmRepository;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void calculate(int resultA, int resultB,
                          int quessA, int quessB) {
        int points = 0;
        if (resultA == quessA && resultB == quessB) {       //kui on täpne skoor
            System.out.println("BINGO! Täpne skoor");
            points = points + 2;
        } else if (resultA > resultB && quessA > quessB) {  //kui kodumeeskond võidab
            points = points + 1;
        } else if (resultA < resultB && quessA < quessB) {  //kui võõrsilmeeskond võidab
            points = points + 1;
        } else if (resultA - resultB == quessA - quessB) {  //kui on viik
            points = points + 1;
        } else {
        }
    }
    public void insertPrediction(String userName, int gameId, int predictionA, int predictionB) {
        mmRepository.insertPrediction(userName, gameId, predictionA, predictionB);
    }
    public void insertRealScore(String gameNr, int resultA, int resultB) {
        mmRepository.insertRealScore(gameNr, resultA, resultB);
    }
}
