package com.example.MM2022.service;

import com.example.MM2022.repository.GameScore;
import com.example.MM2022.repository.MMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MMService {
    @Autowired
    private MMRepository mmRepository;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void calculate(String userName, int gameId) {
        int points = mmRepository.getPoints(userName);
        if (mmRepository.getResultHome(gameId) == mmRepository.getPredictonHome(userName, gameId)
                && mmRepository.getResultAway(gameId) == mmRepository.getPredictionAway(userName, gameId)) {       //kui on täpne skoor
            points = points + 2;
            mmRepository.updateScore(userName, points);
            System.out.println(mmRepository.getPoints(userName) + " BINGO! Täpne skoor");
        } else if (mmRepository.getResultHome(gameId) > mmRepository.getResultAway(gameId)
                && mmRepository.getPredictonHome(userName, gameId) > mmRepository.getPredictionAway(userName, gameId)) {  //kui kodumeeskond võidab
            points = points + 1;
            mmRepository.updateScore(userName, points);
        } else if (mmRepository.getResultHome(gameId) < mmRepository.getResultAway(gameId)
                && mmRepository.getPredictonHome(userName, gameId) < mmRepository.getPredictionAway(userName, gameId)) {  //kui võõrsilmeeskond võidab
            points = points + 1;
            mmRepository.updateScore(userName, points);
        } else if (mmRepository.getResultHome(gameId) - mmRepository.getResultAway(gameId)
                == mmRepository.getPredictonHome(userName, gameId) - mmRepository.getPredictionAway(userName, gameId)) {  //kui on viik
            points = points + 1;
            mmRepository.updateScore(userName, points);
        }
        mmRepository.updateScore(userName, points);
    }

    public void insertPrediction(String userName, int gameId, int predictionA, int predictionB) {
        mmRepository.insertPrediction(userName, gameId, predictionA, predictionB);
    }

    public void insertRealScore(int gameNr, int resultA, int resultB) {
        mmRepository.insertRealScore(gameNr, resultA, resultB);
    }

    public List<GameScore> gameScore() {
        return mmRepository.gameScore();
    }
//    public void getPrediction(String userName, int gameId) {

//        mmRepository.getPrediction(userName, gameId);

//    }


//    public void insertUserAllPrediction(String userName, int gameId, int predictionA, int predictionB) {
//        for (int i = 0; i <= gameId; i++) {
//            for (int j = 1; j <= gameId; j++) {
//                mmRepository.insertUserAllPrediction(userName, gameId, predictionA, predictionB);
//            }
//        }
//    }

//    public void insertUserAllPrediction(String userName, int gameId, int predictionA, int predictionB) {
//        for (int i = 0; i <= gameId; i++) {
//            for (int j = 1; j <= gameId; j++) {
//                mmRepository.insertUserAllPrediction(userName, gameId, predictionA, predictionB);
//            }
//        }
//    }
    /*public List<GamePrediction> showScore(String userName, int score) {
        return mmRepository.showScore(userName, score);
    }*/
}
