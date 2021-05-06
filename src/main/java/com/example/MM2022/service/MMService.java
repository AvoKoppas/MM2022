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
        int points = 0;
        for (int i = 1; i <= gameId; i++) {
            if (mmRepository.getResultHome(i) == mmRepository.getPredictonHome(userName, i)
                    && mmRepository.getResultAway(i) == mmRepository.getPredictionAway(userName, i)) {       //kui on täpne skoor
                points = points + 2;
                System.out.println(" BINGO! Täpne skoor");
            } else if (mmRepository.getResultHome(i) > mmRepository.getResultAway(i)
                    && mmRepository.getPredictonHome(userName, i) > mmRepository.getPredictionAway(userName, i)) {  //kui kodumeeskond võidab
                points = points + 1;
                System.out.println(" Hea! Õige võitja, kodumeeskond võitis");
            } else if (mmRepository.getResultHome(i) < mmRepository.getResultAway(i)
                    && mmRepository.getPredictonHome(userName, i) < mmRepository.getPredictionAway(userName, i)) {  //kui võõrsilmeeskond võidab
                points = points + 1;
                System.out.println(" Hea! Õige võitja, võõrsil meeskond võitis");
            } else if (mmRepository.getResultHome(i) - mmRepository.getResultAway(i)
                    == mmRepository.getPredictonHome(userName, i) - mmRepository.getPredictionAway(userName, i)) {  //kui on viik
                points = points + 1;
                System.out.println(" Hea! Viik");
            }
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
    /*public void insertUserAllPrediction(String userName, int gameId, int predictionA, int predictionB) {
        for (int i = 0; i <= gameId; i++) {

    public void insertUserAllPrediction(String userName, int gameId, int predictionA, int predictionB) {
        for (int i = 1; i <= gameId; i++) {

            for (int j = 1; j <= gameId; j++) {
                mmRepository.insertUserAllPrediction(userName, gameId, predictionA, predictionB);
            }
        }
    }*/

    /*public List<GamePrediction> showScore(String userName, int score) {
        return mmRepository.showScore(userName, score);
    }*/
}
