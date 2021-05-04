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

//    public void calculate(
////            int resultHome, int resultAway,
////                          int predictionHome, int predictionAway
//    ) {
//        int resultHome=mmRepository.getResultHome(String gameId);
//        int points = 0;
//        if (mmRepository.getResultHome() == predictionHome && resultAway == predictionAway) {       //kui on täpne skoor
//            System.out.println("BINGO! Täpne skoor");
//            points = points + 2;
//        } else if (resultHome > resultAway && predictionHome > predictionAway) {  //kui kodumeeskond võidab
//            points = points + 1;
//        } else if (resultHome < resultAway && predictionHome < predictionAway) {  //kui võõrsilmeeskond võidab
//            points = points + 1;
//        } else if (resultHome - resultAway == predictionHome - predictionAway) {  //kui on viik
//            points = points + 1;
//        }
//        mmRepository.calculateScore();
//    }

    public void insertPrediction(String userName, int gameId, int predictionA, int predictionB) {
        mmRepository.insertPrediction(userName, gameId, predictionA, predictionB);
    }

    public void getPrediction(String userName, int gameId) {
        mmRepository.getPrediction(userName, gameId);
    }

    public void insertRealScore(int gameNr, int resultA, int resultB) {
        mmRepository.insertRealScore(gameNr, resultA, resultB);
    }
}
