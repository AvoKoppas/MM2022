package com.example.MM2022.controller;

import com.example.MM2022.repository.GameScore;
import com.example.MM2022.service.MMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MMController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    MMService mmService;

    /*@CrossOrigin
    //http://localhost:8080/createAccount/Veiko/Ilves
    @PostMapping("createAccount/{userName}/{Password}")
    public void createAccount(@PathVariable("userName") String userName,
                                @PathVariable("password") String password) {
        return mmService.createAccount(userName, password);*/



    @CrossOrigin
    //http://localhost:8080/calculateScore/Veiko/1
    @PostMapping("calculateScore/{userName}")
    public int calculateScore(@PathVariable("userName") String userName) {
        return mmService.calculate(userName);
    }

    @CrossOrigin
    //http://localhost:8080/insert/Veiko/1/1/1
    @PostMapping("insert/{userName}/{gameId}/{predictionA}/{predictionB}")
    public void insert(@PathVariable("userName") String userName,
                       @PathVariable("gameId") int gameId,
                       @PathVariable("predictionA") int predictionA,
                       @PathVariable("predictionB") int predictionB) {
        mmService.insertPrediction(userName, gameId, predictionA, predictionB);
    }

    @CrossOrigin
    //http://localhost:8080/insertScore/1/2/4
    @PostMapping("insertScore/{gameNr}/{resultA}/{resultB}")
    public void insertScore(@PathVariable("gameNr") int gameNr,
                            @PathVariable("resultA") int resultA,
                            @PathVariable("resultB") int resultB) {
        mmService.insertRealScore(gameNr, resultA, resultB);
    }

    @CrossOrigin
    //http://localhost:8080/scoreList
    @GetMapping("scoreList")
    public List<GameScore> gameScore() {
        return mmService.gameScore();
    }
    //}


//    //http://localhost:8080/insertUserAllPrediction/Robi///
//    @PostMapping("insertUserAllPrediction/{userName}/{gameId}/{predictionA}/{predictionB}")
//    public void insertUserAllPrediction(@PathVariable("userName") String userName,
//                                        @PathVariable("gameId") int gameId,
//                                        @PathVariable("predictionA") int predictionA,
//                                        @PathVariable("predictionB") int predictionB) {
//        mmService.insertUserAllPrediction(userName, gameId, predictionA, predictionB);


    //http://localhost:8080/insertUserAllPrediction/Robi///
    /*@PostMapping("insertUserAllPrediction/{userName}/{gameId}/{predictionA}/{predictionB}")
    public void insertUserAllPrediction(@PathVariable("userName") String userName,
                                        @PathVariable("gameId") int gameId,
                                        @PathVariable("predictionA") int predictionA,
                                        @PathVariable("predictionB") int predictionB) {
        mmService.insertUserAllPrediction(userName, gameId, predictionA, predictionB);
*/

    /*//http://localhost:8080/showScore/Mari/1
    @GetMapping("showScore/{userName}/{score}")
    public List<GamePrediction> showScore(@PathVariable ("userName") String userName,
                                          @PathVariable("score") int score) {
        return mmService.showScore(userName, score);*/
    //}

//    @PostMapping("")
//    public int(){
//
//    }


}




