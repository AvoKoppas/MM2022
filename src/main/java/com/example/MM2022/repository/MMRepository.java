package com.example.MM2022.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MMRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public int getPoints(String userName) {
        String sql = "SELECT score FROM score_table " +
                "WHERE user_name = :userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", userName);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    //Edetabeli seisu uuendaja.
    public void updateScore(String userName, int points) {
        String sql = "UPDATE score_table SET score=:value WHERE user_name=:userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("value", points);
        paramMap.put("userName", userName);
        jdbcTemplate.update(sql, paramMap);
    }

    //Ennustustetabeli täitja
    public void insertPrediction(String userName, int gameId, int predictionA, int predictionB) {
        String sql = "INSERT INTO prediction (user_name, game_id, home, away) " +
                "VALUES (:name, :id, :predA, :predB)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", userName);
        paramMap.put("id", gameId);
        paramMap.put("predA", predictionA);
        paramMap.put("predB", predictionB);
        jdbcTemplate.update(sql, paramMap);
    }

    //Mängutulemustetabeli täitja
    public void insertRealScore(int gameNr, int resultA, int resultB) {
        String sql = "INSERT INTO football_game (game_nr, home, away)" +
                "VALUES (:number, :resultA, :resultB)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("number", gameNr);
        paramMap.put("resultA", resultA);
        paramMap.put("resultB", resultB);
        jdbcTemplate.update(sql, paramMap);
    }

    //Võtab mängutulemustetabelist koduvõistkonna punktiarvu
    public int getResultHome(int gameId) {
        String sql = "SELECT home FROM football_game " +
                "WHERE game_nr = :gameNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gameNr", gameId);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    //Võtab mängutulemustetabelist võõrsilvõistkonna punktiarvu
    public int getResultAway(int gameId) {
        String sql = "SELECT away FROM football_game " +
                "WHERE game_nr = :gameNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gameNr", gameId);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    //Võtab ennustustetabelist koduvõistkonna punktiarvu
    public int getPredictonHome(String userName, int gameId) {
        String sql = "SELECT home FROM prediction " +
                "WHERE game_id = :gameId AND user_name=:userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gameId", gameId);
        paramMap.put("userName", userName);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    //Võtab ennustustetabelist võõrsilvõistkonna punktiarvu
    public int getPredictionAway(String userName, int gameId) {
        String sql = "SELECT away FROM prediction " +
                "WHERE game_id = :gameId AND user_name=:userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gameId", gameId);
        paramMap.put("userName", userName);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    public void calculateScore() {

    }

    //Kuvab välja mängijate ennustustetabeli
    public List<GameScore> gameScore() {
        String sql = "SELECT * FROM score_table";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.query(sql, paramMap, new GameScoreRowMapper());
    }

    public void insertToScoreTable(String userName) {
        String sql = "INSERT INTO score_table (user_name, score) " +
                "VALUES (:name, :score)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", userName);
        paramMap.put("score", 0);
        jdbcTemplate.update(sql, paramMap);
    }

//        public List<GameScore> gameScore (String userName,int score){


//        public void insertUserAllPrediction (String userName,int gameId, int predictionA, int predictionB){
//            String sql = "INSERT INTO prediction (user_name, game_id, home, away) " +
//                    "VALUES (:name, :id, :predA, :predB)";
//            Map<String, Object> paramMap = new HashMap<>();
//            paramMap.put("name", userName);
//            paramMap.put("id", gameId);
//            paramMap.put("predA", predictionA);
//            paramMap.put("predB", predictionB);
//            jdbcTemplate.update(sql, paramMap);
//        }
//    }*/
    //    public int getPrediction(String userName, int gameId) {
//        String sql = "SELECT home, away FROM prediction " +
//                "WHERE user_name=:muutuja1, game_id = :gameId";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("userName", userName);
//        paramMap.put("gameId", gameId);

//        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);

//    }


}
    /*public List<GamePrediction> showScore(String userName, int score) {

            String sql = "SELECT f.id f_id, game_nr, f.home f_home, f.away f_away, result," +
                    "p.id p_id, user_name, p.home p_home, p.away p_away " +
                    "FROM football_game f JOIN prediction p ON f.id = p.id";
            Map<String, Object> paramMap = new HashMap<>();
            paramMap.put("userName", userName);
            paramMap.put("score", score);
            return jdbcTemplate.query(sql, paramMap, new GameScoreRowMapper());*/





