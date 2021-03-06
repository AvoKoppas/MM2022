package com.example.MM2022.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;

@Repository
public class MMRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public LocalDateTime getKickOff(int gameId) {
        String sql = "SELECT kick_off FROM football_game WHERE game_nr =:gameId";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gameId", gameId);
        return jdbcTemplate.queryForObject(sql, paramMap, LocalDateTime.class);
    }

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
    public Integer getResultHome(int gameId) {
        String sql = "SELECT home FROM football_game " +
                "WHERE game_nr = :gameNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gameNr", gameId);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    //Võtab mängutulemustetabelist võõrsilvõistkonna punktiarvu
    public Integer getResultAway(int gameId) {
        String sql = "SELECT away FROM football_game " +
                "WHERE game_nr = :gameNr";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gameNr", gameId);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    //Võtab ennustustetabelist koduvõistkonna punktiarvu
    public Integer getPredictionHome(String userName, int gameId) {

        String sql = "SELECT home FROM prediction " +
                "WHERE game_id = :gameId AND user_name=:userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gameId", gameId);
        paramMap.put("userName", userName);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }

    //Võtab ennustustetabelist võõrsilvõistkonna punktiarvu
    public Integer getPredictionAway(String userName, int gameId) {
        String sql = "SELECT away FROM prediction " +
                "WHERE game_id = :gameId AND user_name=:userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("gameId", gameId);
        paramMap.put("userName", userName);
        return jdbcTemplate.queryForObject(sql, paramMap, Integer.class);
    }


    //Kuvab välja mängijate ennustustetabeli
    public List<GameScore> gameScore() {
        String sql = "SELECT * FROM score_table ORDER BY score DESC";
        Map<String, Object> paramMap = new HashMap<>();
        return jdbcTemplate.query(sql, paramMap, new GameScoreRowMapper());
    }

    // kontrollib, kas edetabelis on mängija nimi juba olemas
    public boolean doesScoreTableEntryExists(String userName) {
        String sql = "SELECT count(*) > 0 FROM score_table WHERE user_name = :userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", userName);
        return jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
    }

    // võtab edetabelist kõikide kasutajate nimed
    public List<String> getAllUserNames() {
        String sql = "SELECT user_name FROM score_table";
        return jdbcTemplate.queryForList(sql, new HashMap<>(), String.class);
    }

    public void insertToScoreTable(String userName) {
        String sql = "INSERT INTO score_table (user_name, score) " +
                "VALUES (:name, :score)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", userName);
        paramMap.put("score", 0);
        jdbcTemplate.update(sql, paramMap);
    }

    public void createAccount(String userName, String password) {
        String sql = "INSERT INTO registry (user_name, password)" + "VALUES (:name, :password1)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", userName);
        paramMap.put("password1", password);
        jdbcTemplate.update(sql, paramMap);
    }

    public void insertGameNrToFootballGameTable(int gameId) {
        String sql = "INSERT INTO football_game (game_nr) " +
                "VALUES (:id)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", gameId);
        jdbcTemplate.update(sql, paramMap);
    }

    public List<GameScore> gameScoreUser(String userName) {
        String sql = "SELECT * FROM score_table WHERE user_name = :userName";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("userName", userName);
        return jdbcTemplate.query(sql, paramMap, new GameScoreRowMapper());
    }

}