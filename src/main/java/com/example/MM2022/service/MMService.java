package com.example.MM2022.service;

import com.example.MM2022.repository.GameScore;
import com.example.MM2022.repository.MMRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MMService {
    @Autowired
    private MMRepository mmRepository;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    //Meetod arvestab punkte. Teeb seda tsüklina. Tsükli pikkuseks on mängitud mängude arv
    // e. kui tabelisse on sisestatud 4 mängu tulemus, siis meetod teeb 4 tsüklit.
    public int calculate(String userName) {
        int points = 0;
        int gameId = 36;
        for (int i = 1; i <= gameId; i++) {
            try {
                Integer predictionHome = mmRepository.getPredictionHome(userName, i);
                Integer resultHome = mmRepository.getResultHome(i);
                Integer resultAway = mmRepository.getResultAway(i);
                Integer predictionAway = mmRepository.getPredictionAway(userName, i);
                if(resultHome == null || resultAway == null){
                    continue;
                }
                //kui on täpne skoor
                if (resultHome == predictionHome
                        && resultAway == predictionAway) {
                    points = points + 2;
                    System.out.println(" BINGO! Täpne skoor");
                    //kui kodumeeskond võidab
                } else if (resultHome > resultAway
                        && predictionHome > predictionAway) {
                    points = points + 1;
                    System.out.println(" Hea! Õige võitja, kodumeeskond võitis");
                    //kui võõrsilmeeskond võidab
                } else if (resultHome < resultAway
                        && predictionHome < predictionAway) {
                    points = points + 1;
                    System.out.println(" Hea! Õige võitja, võõrsil meeskond võitis");
                    //kui on viik
                } else if (resultHome - resultAway
                        == predictionHome - predictionAway) {
                    points = points + 1;
                    System.out.println(" Hea! Viik");
                }
            } catch(EmptyResultDataAccessException e){
                // no prediction or no results
            }
        }
        mmRepository.updateScore(userName, points);
        return mmRepository.getPoints(userName);
    }

    //Sisestab ennustustetabelisse ühe kasutaja ennustused.
    public void insertPrediction(String userName, int gameId, int predictionA, int predictionB) {
        if (!mmRepository.doesScoreTableEntryExists(userName)) {
            mmRepository.insertToScoreTable(userName);
        }
        mmRepository.insertPrediction(userName, gameId, predictionA, predictionB);
    }

    // Sisestab tabelisse päriselu mängutulemused.
    public void insertRealScore(int gameNr, int resultA, int resultB) {
        mmRepository.insertRealScore(gameNr, resultA, resultB);
    }

    //Kuvab välja mängijate edetabeli!
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
