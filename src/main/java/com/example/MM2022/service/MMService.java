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

    public int calculate(String userName, int gameId) {
        int points = 0;
        if (mmRepository.getResultHome(gameId) == mmRepository.getPredictonHome(userName, gameId)
                && mmRepository.getResultAway(gameId) == mmRepository.getPredictionAway(userName, gameId)) {       //kui on täpne skoor
            System.out.println("BINGO! Täpne skoor");
            points = points + 2;
            return points;
        } else if (mmRepository.getResultHome(gameId) > mmRepository.getResultAway(gameId)
                && mmRepository.getPredictonHome(userName, gameId) > mmRepository.getPredictionAway(userName, gameId)) {  //kui kodumeeskond võidab
            points = points + 1;
            return points;
        } else if (mmRepository.getResultHome(gameId) < mmRepository.getResultAway(gameId)
                && mmRepository.getPredictonHome(userName, gameId) < mmRepository.getPredictionAway(userName, gameId)) {  //kui võõrsilmeeskond võidab
            points = points + 1;
            return points;
        } else if (mmRepository.getResultHome(gameId) - mmRepository.getResultAway(gameId)
                == mmRepository.getPredictonHome(userName, gameId) - mmRepository.getPredictionAway(userName, gameId)) {  //kui on viik
            points = points + 1;
            return points;
        }
        return -1;
    }

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
